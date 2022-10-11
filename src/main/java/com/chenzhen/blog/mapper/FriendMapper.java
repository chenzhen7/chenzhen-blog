package com.chenzhen.blog.mapper;
import org.apache.ibatis.annotations.Param;

import com.chenzhen.blog.pojo.Friend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author MIS
* @description 针对表【t_friend】的数据库操作Mapper
* @createDate 2022-09-11 18:21:11
* @Entity com.chenzhen.blog.pojo.Friend
*/
@Mapper
public interface FriendMapper extends BaseMapper<Friend> {


    Friend selectOneByBlogAddress(@Param("blogAddress") String blogAddress);

}




