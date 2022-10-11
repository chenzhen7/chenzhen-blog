package com.chenzhen.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/20 22:10
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
public class MusicController {

    @GetMapping("/music")
    public String music(){
        return "music";
    }
}
