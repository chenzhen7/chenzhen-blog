package com.chenzhen.blog.controller;

import com.chenzhen.blog.pojo.Comment;
import com.chenzhen.blog.pojo.User;
import com.chenzhen.blog.service.CommentService;
import com.chenzhen.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/13 11:18
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @Value("${comment.avatar}")
    private String avatar;

    //查询评论列表
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> rootCommentList = commentService.getRootCommentList(blogId);//获取所有根评论，并且注入回复列表
        model.addAttribute("commentList", rootCommentList);
        return "blog :: commentList";
    }

    //新增评论
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws MessagingException {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            //设置头像
            comment.setAvatar(avatar);
        }
        int i = commentService.saveComment(comment);

        commentService.sendMail(user, comment, request, response);

        return "redirect:/comments/"+comment.getBlog().getId();

    }

    //删除评论
    @GetMapping("/comments/{id}/delete")
    public String delete(@PathVariable("id")Long commentId, @RequestParam("blogId")Long blogId,HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user != null){
            commentService.removeById(commentId);
        }
        return "redirect:/blog/"+blogId;
    }

}
