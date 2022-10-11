package com.chenzhen.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @TableName t_message
 */
@TableName(value ="t_message")
public class Message implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private boolean adminMessage;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private Message parentMessage;
    @TableField(exist = false)
    private Message rootMessage;
    @TableField(exist = false)
    private List<Message> replyList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isAdminMessage() {
        return adminMessage;
    }

    public void setAdminMessage(boolean adminMessage) {
        this.adminMessage = adminMessage;
    }

    public Message getParentMessage() {
        return parentMessage;
    }

    public void setParentMessage(Message parentMessage) {
        this.parentMessage = parentMessage;
    }

    public Message getRootMessage() {
        return rootMessage;
    }

    public void setRootMessage(Message rootMessage) {
        this.rootMessage = rootMessage;
    }

    public List<Message> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Message> replyList) {
        this.replyList = replyList;
    }
}