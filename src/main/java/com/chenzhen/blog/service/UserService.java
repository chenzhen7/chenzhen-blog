package com.chenzhen.blog.service;

import com.chenzhen.blog.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author MIS
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-09-11 18:21:11
*/
public interface UserService extends IService<User> {
    /**
     * 根据username和password查找用户
     */
    User checkUser(String username,String password);

}
