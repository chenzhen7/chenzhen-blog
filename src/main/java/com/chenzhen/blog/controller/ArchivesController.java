package com.chenzhen.blog.controller;

import com.chenzhen.blog.mapper.BlogMapper;
import com.chenzhen.blog.pojo.Blog;
import com.chenzhen.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/15 22:08
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
public class ArchivesController {

    @Autowired
    private BlogMapper blogMapper;

    @GetMapping("/archives")
    public String archives(Model model){
        List<Blog> memoryList = blogMapper.getArchivesList();
        model.addAttribute("memoryList",memoryList);
        return "archives";
    }
}
