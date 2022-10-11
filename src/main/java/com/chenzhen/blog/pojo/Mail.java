package com.chenzhen.blog.pojo;

import java.util.Date;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/27 11:52
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
public class Mail {

    //发件人邮箱账号（固定为我自己 即博主本人）
    private String sendMailAccount;
    //收件人邮箱账号
    private String acceptMailAccount;
    //收件人姓名
    private String name;
    //收件人评论的内容
    private String comment;
    //回复收件人的 回复者的姓名
    private String respondent;
    //回复者的回复内容
    private String reply;
    //评论发生的地方链接（回复者是在哪里回复收件人的）
    private String address;
    //邮件主题
    private String theme;
    //发送时间
    private Date sendTime = new Date();

    public Mail() {
    }

    public Mail(String sendMailAccount, String acceptMailAccount, String name, String comment, String respondent, String reply, String address, String theme) {
        this.sendMailAccount = sendMailAccount;
        this.acceptMailAccount = acceptMailAccount;
        this.name = name;
        this.comment = comment;
        this.respondent = respondent;
        this.reply = reply;
        this.address = address;
        this.theme = theme;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSendMailAccount() {
        return sendMailAccount;
    }

    public void setSendMailAccount(String sendMailAccount) {
        this.sendMailAccount = sendMailAccount;
    }

    public String getAcceptMailAccount() {
        return acceptMailAccount;
    }

    public void setAcceptMailAccount(String acceptMailAccount) {
        this.acceptMailAccount = acceptMailAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRespondent() {
        return respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
