package com.chenzhen.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenzhen.blog.pojo.Friend;
import com.chenzhen.blog.service.FriendService;
import com.chenzhen.blog.mapper.FriendMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author MIS
* @description 针对表【t_friend】的数据库操作Service实现
* @createDate 2022-09-11 18:21:11
*/
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend>
    implements FriendService{

    @Override
    public PageInfo<Friend> pageFriendLinks(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("create_time desc");
        List<Friend> list = list();
        PageInfo<Friend> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public int insert(Friend friend) {
        friend.setCreateTime(new Date());
        int insert = getBaseMapper().insert(friend);
        return insert;
    }
}




