package com.chenzhen.blog.controller;

import com.chenzhen.blog.pojo.Friend;
import com.chenzhen.blog.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/17 11:47
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
public class FriendLinkController {
    @Autowired
    private FriendService friendService;

    @GetMapping("/friends")
    public String friendLink(Model model){
        List<Friend> list = friendService.list();
        model.addAttribute("friendlinks",list);

        return "friends";
    }
}
