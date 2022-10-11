package com.chenzhen.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenzhen.blog.pojo.User;
import com.chenzhen.blog.service.UserService;
import com.chenzhen.blog.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
* @author MIS
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-09-11 18:21:11
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public User checkUser(String username, String password) {
//        MD5加密
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());

        User user = getBaseMapper().selectOneByUsernameAndPassword(username, md5DigestAsHex);

        return user;
    }
}




