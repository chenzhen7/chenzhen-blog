package com.chenzhen.blog.service;

import com.chenzhen.blog.pojo.Mail;
import com.chenzhen.blog.pojo.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenzhen.blog.pojo.User;
import com.github.pagehelper.PageInfo;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
* @author MIS
* @description 针对表【t_message】的数据库操作Service
* @createDate 2022-09-11 18:21:11
*/
public interface MessageService extends IService<Message> {

    PageInfo<Message> getMessageList(Integer pageNum);

    /**
     * @param message
     * @return
     */
    int saveMessage(Message message);

    /**
     * 新增邮件回复功能，有回复消息会有邮件提醒
     */
    void sendMail(User user, Message message) throws MessagingException;

}
