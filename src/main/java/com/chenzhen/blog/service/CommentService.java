package com.chenzhen.blog.service;

import com.chenzhen.blog.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenzhen.blog.pojo.User;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
* @author MIS
* @description 针对表【t_comment】的数据库操作Service
* @createDate 2022-09-11 18:21:11
*/
public interface CommentService extends IService<Comment> {

    List<Comment> getRootCommentList(Long blogId);

    int saveComment(Comment comment);

    List<Comment> getReplyList(Long rootCommentId,Long blogId);

    /**
     * 新增邮件回复功能，有回复消息会有邮件提醒
     * @param user  传入用户参数，判断是否为管理员
     * @param comment  评论
     * @param request
     * @param response
     */
    void sendMail(User user, Comment comment, HttpServletRequest request, HttpServletResponse response) throws MessagingException;

}
