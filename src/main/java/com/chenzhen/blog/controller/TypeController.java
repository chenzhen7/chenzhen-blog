package com.chenzhen.blog.controller;

import com.chenzhen.blog.mapper.TypeMapper;
import com.chenzhen.blog.pojo.Blog;
import com.chenzhen.blog.pojo.Type;
import com.chenzhen.blog.service.BlogService;
import com.chenzhen.blog.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/14 15:58
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    //获取分类页面所有的分类
    @GetMapping(value = {"/types/{typeId}","/types"})
    public String types(@PathVariable(value = "typeId",required = false)Long typeId,
                        @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                        Model model){
        List<Type> typeList = typeService.getTypeList();//获得所有分类列表
        model.addAttribute("typeList",typeList);
        if (typeId == null){
            typeId = typeList.get(0).getId();
        }
        PageInfo<Blog> pageInfo = blogService.pageTypes(typeId, pageNum, 8);
        model.addAttribute("page",pageInfo);
        model.addAttribute("currType",typeId);//目前所在的分类添加到model中，使页面可以获取
        return "types";
    }

}
