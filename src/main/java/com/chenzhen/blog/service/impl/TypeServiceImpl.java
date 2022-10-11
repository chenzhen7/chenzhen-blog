package com.chenzhen.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenzhen.blog.pojo.Type;
import com.chenzhen.blog.service.TypeService;
import com.chenzhen.blog.mapper.TypeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIS
* @description 针对表【t_type】的数据库操作Service实现
* @createDate 2022-09-11 18:21:11
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

    @Override
    public PageInfo<Type> pageTypeList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id desc");
        List<Type> typeList = getBaseMapper().selectList(null);
        PageInfo<Type> pageInfo = new PageInfo<>(typeList, 5);

        return pageInfo;

    }

    @Override
    public List<Type> getTypeList() {
        List<Type> typeList = getBaseMapper().getTypeList();//type中注入blogList

        return typeList;
    }
}




