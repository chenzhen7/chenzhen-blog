package com.chenzhen.blog.controller;

import com.chenzhen.blog.mapper.PictureMapper;
import com.chenzhen.blog.pojo.Blog;
import com.chenzhen.blog.pojo.Picture;
import com.chenzhen.blog.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/11 15:43
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private PictureMapper pictureMapper;

    //跳转首页
    @GetMapping(value = {"/","/{pageNum}"})
    public String index(@PathVariable(value = "pageNum",required = false)Integer pageNum, Model model){
        if (pageNum==null){
            pageNum=1;
        }

//        long start=System.currentTimeMillis();

        PageInfo<Blog> pageInfo = blogService.pageIndex(pageNum, 12);//获取首页博客列表分页信息

//        long end=System.currentTimeMillis();
//        Logger logger = LoggerFactory.getLogger(this.getClass());
//        logger.info("当前程序运行多少毫秒 = {}",end-start);

        List<Blog> recommendList = blogService.getRecommendList();//获取推荐列表

        List<Picture> pictureList = pictureMapper.selectList(null);//获取首页的顶图地址
        Picture picture = pictureList.get(0);

        model.addAttribute("picture",picture);//壁纸地址
        model.addAttribute("page",pageInfo);//首页博客列表分页信息
        model.addAttribute("recommendList",recommendList);//推荐列表

        return "index";
    }

    //跳转博客详情页
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable("id")Long id,Model model){
        Blog blog = blogService.getBlogDetail(id);
        model.addAttribute("blog",blog);
        return "blog";
    }
}
