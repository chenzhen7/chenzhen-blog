package com.chenzhen.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_friend
 */
@TableName(value ="t_friend")
public class Friend implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    private String blogAddress;
    private String blogName;
    private Date createTime;
    private String pictureAddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
    public String getBlogAddress() {
        return blogAddress;
    }

    /**
     * 
     */
    public void setBlogAddress(String blogAddress) {
        this.blogAddress = blogAddress;
    }

    /**
     * 
     */
    public String getBlogName() {
        return blogName;
    }

    /**
     * 
     */
    public void setBlogName(String blogName) {
        this.blogName = blogName;
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

    /**
     * 
     */
    public String getPictureAddress() {
        return pictureAddress;
    }

    /**
     * 
     */
    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }
}