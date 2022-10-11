package com.chenzhen.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenzhen.blog.mapper.CommentMapper;
import com.chenzhen.blog.mapper.TypeMapper;
import com.chenzhen.blog.pojo.Blog;
import com.chenzhen.blog.pojo.Comment;
import com.chenzhen.blog.pojo.Type;
import com.chenzhen.blog.service.BlogService;
import com.chenzhen.blog.mapper.BlogMapper;
import com.chenzhen.blog.service.CommentService;
import com.chenzhen.blog.util.MarkdownUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* @author MIS
* @description 针对表【t_blog】的数据库操作Service实现
* @createDate 2022-09-11 18:21:11
*/
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{


    @Autowired
    private TypeMapper typeMapper;

    @Override
    public PageInfo<Blog> pageAdminBlogs(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("create_time desc");
        List<Blog> blogList = getSomeFieldsOnBlogsPage();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList, 5);
        return pageInfo;

    }

    @Override
    public List<Blog> getSomeFieldsOnBlogsPage() {
        List<Blog> blogList = getBaseMapper().getSomeFieldsOnBlogsPage();//获得[博客管理]页面需要的字段，type中只有id

        for (Blog blog : blogList){//为blog中的type注入name属性
            Type type = typeMapper.selectById(blog.getType().getId());
            blog.setType(type);
        }

        return blogList;
    }

    @Override
    public Integer newBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        int i = getBaseMapper().insertBlog(blog);

        return i;
    }

    @Override
    public Blog getSomeFieldsOnEditPage(Long blogId) {
        Blog blog = getBaseMapper().getSomeFieldsOnEditPage(blogId);

        return blog;
    }

    @Override
    public int updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        int i = getBaseMapper().updateSelective(blog);
        return i;
    }

    @Override
    public Boolean removeBlog(Serializable id) {
        return removeById(id);
    }

    @Override
    public PageInfo<Blog> pageIndex(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("create_time desc");
        List<Blog> blogList = getBaseMapper().getSomeFieldsOnIndexPage();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList, 5);

        return pageInfo;

    }

    @Override
    public List<Blog> getRecommendList() {
        List<Blog> recommendList = getBaseMapper().getRecommendList();

        return recommendList;
    }

    @Transactional
    @Override
    public Blog getBlogDetail(Long id) {
        Blog blog = getBaseMapper().getBlogDetail(id);//type只有id属性
        Type type = typeMapper.selectById(blog.getType().getId());//注入type
        blog.setType(type);
        String html = MarkdownUtil.markdownToHtml(blog.getContent());//Markdown语法转html
        blog.setContent(html);
        getBaseMapper().updateViews(blog.getId());//更新浏览次数+1
        return blog;
    }

    @Override
    public PageInfo<Blog> pageTypes(Long typeId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("update_time desc");
        List<Blog> blogList = getBaseMapper().getBlogListByTypeId(typeId);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public Long getBlogViewTotal() {
        Long countViews = getBaseMapper().countViews();

        return countViews;
    }




}




