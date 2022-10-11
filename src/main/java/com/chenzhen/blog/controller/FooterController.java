package com.chenzhen.blog.controller;

import com.chenzhen.blog.service.BlogService;
import com.chenzhen.blog.service.CommentService;
import com.chenzhen.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/17 10:26
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
@RequestMapping("/footer")
public class FooterController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/blogmessage")
    public String blogMessage(Model model){
        Long blogTotal = blogService.count();
        Long blogViewTotal = blogService.getBlogViewTotal();
        Long blogCommentTotal = commentService.count();
        Long blogMessageTotal = messageService.count();

        model.addAttribute("blogTotal",blogTotal);
        model.addAttribute("blogViewTotal",blogViewTotal);
        model.addAttribute("blogCommentTotal",blogCommentTotal);
        model.addAttribute("blogMessageTotal",blogMessageTotal);


        return "index :: blogMessage";
    }
}
