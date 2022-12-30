package com.chenzhen.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenzhen.blog.mapper.BlogMapper;
import com.chenzhen.blog.pojo.*;
import com.chenzhen.blog.service.CommentService;
import com.chenzhen.blog.mapper.CommentMapper;
import com.chenzhen.blog.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
* @author MIS
* @description 针对表【t_comment】的数据库操作Service实现
* @createDate 2022-09-11 18:21:11
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private MailUtil mailUtil;

    @Value("${spring.mail.username}") //从yaml配置文件中获取
    private String myMail; //我自己的邮箱地址
    @Value("${spring.mail.myname}")
    private String myName;


    @Override
    public List<Comment> getRootCommentList(Long blogId) {
        List<Comment> rootCommentList = getBaseMapper().getRootCommentList(blogId);//获得所有根评论，未注入回复评论

        for (Comment rootComment : rootCommentList){//为所有根评论注入回复评论
            List<Comment> replyList = getReplyList(rootComment.getId(), rootComment.getBlog().getId());//根据博客id和根评论id获取回复评论
            rootComment.setReplyCommentList(replyList);
        }

        return rootCommentList;
    }

    @Transactional
    @Override
    public int saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        blogMapper.updateCommentCount(comment.getBlog().getId()); //更新博客的评论数量
        int i = getBaseMapper().saveComment(comment);
        return i;
    }

    public List<Comment> getReplyList(Long rootCommentId,Long blogId){
        List<Comment> replyList = getBaseMapper().getReplyList(rootCommentId, blogId);//根据博客id和根评论id获取回复评论
        return replyList;
    }

    @Override
    @Async("asyncThreadPoolTaskExecutor")  //设置为一个异步方法
    public void sendMail(User user, Comment comment , HttpServletRequest request, HttpServletResponse response) throws MessagingException {

        String title = blogMapper.getTitleById(comment.getBlog().getId()); //评论所在的博文标题

        if (user!=null){
            //如果是管理员发的评论
            if (comment.getParentComment().getId()==null || comment.getParentComment()==null){
                //如果是根评论
                //不需要发给自己邮件
                return;
            }else {
                //如果不是根评论，则给[我回复的对象]发一封提醒邮件
                Comment parentComment = commentMapper.selectById(comment.getParentComment().getId());//获取父评论

                Mail mail = new Mail(null, parentComment.getEmail(), parentComment.getNickname(), parentComment.getContent(),
                        comment.getNickname(), comment.getContent(),
                        "/blog/"+comment.getBlog().getId(), "您在"+myName+"的博客《"+title+"》中的评论有了新的回复！");
                mailUtil.sendThymeleafEmail(mail);
            }
        }else {
            //如果不是管理员发的评论
            if (comment.getParentComment().getId()==null || comment.getParentComment()==null){
                //如果是根评论
                //发给我自己，提醒有人在留言板留言了
                Mail mail = new Mail(null, myMail, myName, null,
                        comment.getNickname(), comment.getContent(),
                        "/blog/"+comment.getBlog().getId(),"您在"+myName+"的博客《"+title+"》中有了新的评论！");
                mailUtil.sendThymeleafEmail(mail);

            }else{
                //如果不是根评论
                //给回复者[回复的对象]发一份提醒邮件
                Comment parentComment = commentMapper.selectById(comment.getParentComment().getId());//获取父评论
                Mail mail = new Mail(null,parentComment.getEmail(),parentComment.getNickname(),
                        parentComment.getContent(),comment.getNickname(),comment.getContent(),
                        "/blog/"+comment.getBlog().getId(),"您在"+myName+"的博客《"+title+"》中的评论有了新的回复！");
                mailUtil.sendThymeleafEmail(mail);

            }

        }
    }


}




