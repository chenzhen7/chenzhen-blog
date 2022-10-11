package com.chenzhen.blog.mapper;

import com.chenzhen.blog.pojo.Picture;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author MIS
* @description 针对表【t_picture】的数据库操作Mapper
* @createDate 2022-09-11 18:21:11
* @Entity com.chenzhen.blog.pojo.Picture
*/
@Mapper
public interface PictureMapper extends BaseMapper<Picture> {

}




