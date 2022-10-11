package com.chenzhen.blog.controller.admin;

import com.chenzhen.blog.mapper.TypeMapper;
import com.chenzhen.blog.pojo.Blog;
import com.chenzhen.blog.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/11 19:00
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
@RequestMapping("/admin")
public class AdminBlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeMapper typeMapper;


    //跳转[博客列表]页面
    @GetMapping(value = {"/blogs/{pageNum}","/blogs"})
    public String blogs(Model model, @PathVariable(value = "pageNum",required = false)Integer pageNum){
        if (pageNum==null){
            pageNum = 1;
        }
        PageInfo<Blog> pageInfo = blogService.pageAdminBlogs(pageNum, 6);
        model.addAttribute("page",pageInfo);

        return "admin/blogs";
    }

    //跳转[博客新增]页面
    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("typeList",typeMapper.selectList(null));

        return "admin/blogs-input";
    }


    //发布博客
    @PostMapping("/blogs")
    public String newBlog(Blog blog, RedirectAttributes attributes, HttpSession session){
        if (blog!=null){//传过来的blog不为空
            Integer i = blogService.newBlog(blog);
            if(i > 0){
                attributes.addFlashAttribute("message", "新增成功");
            }else {
                attributes.addFlashAttribute("message", "新增失败");
            }
            return "redirect:/admin/blogs";
        }else {
            attributes.addFlashAttribute("message", "没有传入博客参数");
            return "redirect:/admin/blogs";
        }
    }

    //跳转[博客编辑]页面
    @GetMapping("/blogs/{id}/edit")
    public String editPage(@PathVariable("id") Long blogId,Model model){
        model.addAttribute("typeList",typeMapper.selectList(null));
        model.addAttribute("blog",blogService.getSomeFieldsOnEditPage(blogId));

        return "admin/blogs-edit";
    }

    //更新博客
    @PutMapping("/blogs")
    public String updateBlog(Blog blog,RedirectAttributes attributes){
        int i = blogService.updateBlog(blog);
        if(i > 0){
            attributes.addFlashAttribute("message", "修改成功");
        }else {
            attributes.addFlashAttribute("message", "修改失败");
        }
        return "redirect:/admin/blogs";
    }

    //删除博客
    @GetMapping("/blogs/{id}/delete")
    public String deleteBlog(@PathVariable("id") Long id,RedirectAttributes attributes){
        boolean b = blogService.removeBlog(id);
        if(b == true){
            attributes.addFlashAttribute("message", "删除成功");
        }else {
            attributes.addFlashAttribute("message", "删除失败");
        }

        return "redirect:/admin/blogs";
    }

}
