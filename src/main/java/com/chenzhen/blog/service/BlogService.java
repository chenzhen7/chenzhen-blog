package com.chenzhen.blog.service;

import com.chenzhen.blog.pojo.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenzhen.blog.pojo.Comment;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
* @author MIS
* @description 针对表【t_blog】的数据库操作Service
* @createDate 2022-09-11 18:21:11
*/
public interface BlogService extends IService<Blog> {

    //分页显示[博客管理列表]
    PageInfo<Blog> pageAdminBlogs(Integer pageNum,Integer pageSize);

    //获取[博客管理列表]的博客信息
    List<Blog> getSomeFieldsOnBlogsPage();

    //发布博客
    Integer newBlog(Blog blog);

    //获取[博客编辑页面]的博客信息
    Blog getSomeFieldsOnEditPage(Long blogId);

    //更新博客
    int updateBlog(Blog blog);

    //分页显示[首页博客列表]
    PageInfo<Blog> pageIndex(Integer pageNum,Integer pageSize);

    //获取推荐列表
    List<Blog> getRecommendList();

    Blog getBlogDetail(Long id);

    PageInfo<Blog> pageTypes(Long typeId,Integer pageNum,Integer pageSize);

    //所有博客浏览量总数
    Long getBlogViewTotal();

    Boolean removeBlog(Serializable id);



}
