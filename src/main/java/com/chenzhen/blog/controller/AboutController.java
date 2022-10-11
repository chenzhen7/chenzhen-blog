package com.chenzhen.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/17 21:22
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
