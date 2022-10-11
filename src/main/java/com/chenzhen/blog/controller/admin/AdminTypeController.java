package com.chenzhen.blog.controller.admin;

import com.chenzhen.blog.mapper.TypeMapper;
import com.chenzhen.blog.pojo.Type;
import com.chenzhen.blog.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/12 16:13
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
@RequestMapping("/admin")
public class AdminTypeController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private TypeMapper typeMapper;

    //跳转[博客分类管理]页面
    @GetMapping(value = {"/types/{pageNum}","/types"})
    public String types(@PathVariable(value = "pageNum",required = false) Integer pageNum, Model model){
        if (pageNum==null){
            pageNum = 1;
        }
        PageInfo<Type> pageInfo = typeService.pageTypeList(pageNum,5);
        model.addAttribute("page",pageInfo);

        return "admin/types";
    }

    //跳转[分类新增]页面
    @GetMapping("/types/input")
    public String input(){
        return "admin/types-input";
    }

    //新增分类
    @PostMapping("/types")
    public String newType(Type type, RedirectAttributes attributes){
        if (type==null){
            attributes.addFlashAttribute("message", "新增失败");
            return "redirect:/admin/types";
        }
        if (typeMapper.selectOneByName(type.getName()) != null){
            attributes.addFlashAttribute("message","不能添加重复的分类");
            return "redirect:/admin/types/input";
        }else {
            boolean save = typeService.save(type);
            if (save == true){
                attributes.addFlashAttribute("message", "新增成功");
            }else {
                attributes.addFlashAttribute("message", "新增失败");
            }

            return "redirect:/admin/types";
        }

    }

    //跳转[分类编辑]页面
    @GetMapping("/types/{id}/edit")
    public String edit(@PathVariable("id") Long id,Model model){
        Type type = typeService.getById(id);
        model.addAttribute("type",type);
        return "/admin/types-edit";
    }

    @PutMapping("/types")
    public String updateType(Type type,RedirectAttributes attributes){
        if (typeMapper.selectOneByName(type.getName()) != null){
            attributes.addFlashAttribute("message","不能添加重复的分类");
            return "redirect:/admin/types/"+type.getId()+"/edit";
        }
            boolean b = typeService.updateById(type);
            if (b == true){
                attributes.addFlashAttribute("message", "修改成功");
            }else {
                attributes.addFlashAttribute("message", "修改失败");
            }
            return "redirect:/admin/types";

    }


}
