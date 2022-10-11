package com.chenzhen.blog.controller;

import com.chenzhen.blog.pojo.Mail;
import com.chenzhen.blog.pojo.Message;
import com.chenzhen.blog.pojo.User;
import com.chenzhen.blog.service.MessageService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/15 22:53
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Value("${comment.avatar}")
    private String avatar;

    //显示留言板页面
    @GetMapping(value = {"/message/{pageNum}","/message"})
    public String message(Model model,@PathVariable(value = "pageNum",required = false)Integer pageNum){//从首页点进页面需要加载page信息，否则页面会报空指针
        if (pageNum == null){
            pageNum = 1;
        }
        PageInfo<Message> pageInfo = messageService.getMessageList(pageNum);
        model.addAttribute("page",pageInfo);
        return "message";
    }

    //查询评论列表
    @GetMapping(value = {"/messagecomment","/messagecomment/{pageNum}"})
    public String messageComment(@PathVariable(value = "pageNum",required = false) Integer pageNum, Model model) {
        if (pageNum == null){
            pageNum = 1;
        }
        PageInfo<Message> pageInfo = messageService.getMessageList(pageNum);
        model.addAttribute("page",pageInfo);

        return "message :: messageList";
    }

    //新增评论
    @PostMapping("/message")
    public String message(Message message, HttpSession session, Integer pageNum,
                          HttpServletRequest request,
                          HttpServletResponse response) throws MessagingException {
        User user = (User) session.getAttribute("user");
        if (user != null) {//如果是管理员，设置管理员的权限
            message.setAvatar(user.getAvatar());
            message.setAdminMessage(true);
        } else {//如果不是管理员
            //设置头像
            message.setAvatar(avatar);
        }
        int i = messageService.saveMessage(message);//将评论信息保存数据库

        messageService.sendMail(user,message);//发送评论提醒邮件


        return "redirect:/messagecomment/"+pageNum;


    }

    //删除评论
    @GetMapping("/message/{id}/delete")
    public String delete(@PathVariable("id")Long id,HttpSession session,Integer pageNum){
        User user = (User) session.getAttribute("user");
        if(user != null){
            boolean b = messageService.removeById(id);
        }
        return "redirect:/message/"+pageNum;

    }

}
