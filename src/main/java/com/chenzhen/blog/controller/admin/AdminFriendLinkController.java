package com.chenzhen.blog.controller.admin;

import com.chenzhen.blog.mapper.FriendMapper;
import com.chenzhen.blog.pojo.Friend;
import com.chenzhen.blog.service.FriendService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/17 11:52
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
@RequestMapping("/admin")
public class AdminFriendLinkController {

    @Autowired
    private FriendService friendService;
    @Autowired
    private FriendMapper friendMapper;

    //跳转[友链管理]页面
    @GetMapping(value = {"/friendlinks","/friendlinks/{pageNum}"})
    public String friendlinks(@PathVariable(value = "pageNum",required = false)Integer pageNum, Model model){
        if (pageNum==null){
            pageNum = 1;
        }
        PageInfo<Friend> pageInfo = friendService.pageFriendLinks(pageNum, 6);
        model.addAttribute("pageInfo",pageInfo);

        return "admin/friendlinks";
    }
    //跳转[新增友链]页面
    @GetMapping("/friendlinks/input")
    public String input(){
        return "admin/friendlinks-input";
    }
    //新增友链
    @PostMapping("/friendlinks")
    public String newFriendlinks(Friend friend, RedirectAttributes attributes){
        if (friend==null){
            attributes.addFlashAttribute("message", "新增失败");

        }else if(friendMapper.selectOneByBlogAddress(friend.getBlogAddress())!=null){
            attributes.addFlashAttribute("message", "新增失败,不能添加重复友链");

        }else{

            int insert = friendService.insert(friend);
            if (insert > 0){
                attributes.addFlashAttribute("message", "新增成功");
            }else {
                attributes.addFlashAttribute("message", "新增失败");
            }
        }
        return "redirect:/admin/friendlinks";

    }
    @GetMapping("/friendlinks/{id}/edit")
    public String edit(@PathVariable("id")Long id,Model model){
        Friend friend = friendService.getById(id);
        model.addAttribute("friendlink",friend);
        return "admin/friendlinks-edit";
    }
    //更新友链
    @PutMapping("/friendlinks")
    public String editFriendlinks(Friend friend,RedirectAttributes attributes){
        if (friend==null){
            attributes.addFlashAttribute("message", "更新失败");
        }else{
            boolean b = friendService.updateById(friend);
            if (b==true){
                attributes.addFlashAttribute("message", "更新成功");
            }else {
                attributes.addFlashAttribute("message","更新失败");
            }
        }
        return "redirect:/admin/friendlinks";


    }



    //删除友链
    @GetMapping("/friendlinks/{id}/delete")
    public String deleteFriendlinks(@PathVariable("id")Long id,RedirectAttributes attributes){
        boolean b = friendService.removeById(id);
        if (b==true){
            attributes.addFlashAttribute("message", "删除成功");
        }else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/friendlinks";
    }



}
