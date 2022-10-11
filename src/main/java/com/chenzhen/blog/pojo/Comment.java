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
 * @TableName t_comment
 */
@TableName(value ="t_comment")
public class Comment implements Serializable {
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
    private boolean adminComment;//是否为管理员评论

    @TableField(exist = false)
    private Blog blog;
    @TableField(exist = false)
    private Comment parentComment;//父评论（即该评论回复的评论） 根评论的第一条回复中的父评论也是根评论
    @TableField(exist = false)
    private Comment rootComment;//根评论（即该评论最终回复的[最顶层]的评论）
    @TableField(exist = false)
    private List<Comment> replyCommentList;//该评论的回复列表（只有根评论有回复列表）

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    public Boolean isAdminComment() {
        return adminComment;
    }

    public void setAdminComment(Boolean adminComment) {
        this.adminComment = adminComment;
    }

    public List<Comment> getReplyCommentList() {
        return replyCommentList;
    }

    public void setReplyCommentList(List<Comment> replyCommentList) {
        this.replyCommentList = replyCommentList;
    }

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Comment getRootComment() {
        return rootComment;
    }

    public void setRootComment(Comment rootComment) {
        this.rootComment = rootComment;
    }
}