package com.chenzhen.blog.mapper;
import org.apache.ibatis.annotations.Param;

import com.chenzhen.blog.pojo.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author MIS
* @description 针对表【t_blog】的数据库操作Mapper
* @createDate 2022-09-11 18:21:11
* @Entity com.chenzhen.blog.pojo.Blog
*/
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    List<Blog> getSomeFieldsOnBlogsPage();

    int insertBlog(Blog blog);

    Blog getSomeFieldsOnEditPage(Long blogId);

    int updateSelective(Blog blog);

    List<Blog> getSomeFieldsOnIndexPage();

    List<Blog> getRecommendList();

    Blog getBlogDetail(Long id);

    int updateViews(Long blogId);

    int updateCommentCount(Long blogId);

    List<Blog> getBlogListByTypeId(Long typeId);

    List<Blog> getArchivesList();

    Long countViews();

    String getTitleById(@Param("id") Long id);



}




