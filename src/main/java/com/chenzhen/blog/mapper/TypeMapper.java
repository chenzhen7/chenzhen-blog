package com.chenzhen.blog.mapper;
import org.apache.ibatis.annotations.Param;

import com.chenzhen.blog.pojo.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author MIS
* @description 针对表【t_type】的数据库操作Mapper
* @createDate 2022-09-11 18:21:11
* @Entity com.chenzhen.blog.pojo.Type
*/
@Mapper
public interface TypeMapper extends BaseMapper<Type> {

    Type selectOneByName(@Param("name") String name);

    List<Type> getTypeList();

}




