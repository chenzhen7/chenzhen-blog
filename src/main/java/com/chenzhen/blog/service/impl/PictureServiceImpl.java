package com.chenzhen.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenzhen.blog.pojo.Picture;
import com.chenzhen.blog.service.PictureService;
import com.chenzhen.blog.mapper.PictureMapper;
import org.springframework.stereotype.Service;

/**
* @author MIS
* @description 针对表【t_picture】的数据库操作Service实现
* @createDate 2022-09-11 18:21:11
*/
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture>
    implements PictureService{

}




