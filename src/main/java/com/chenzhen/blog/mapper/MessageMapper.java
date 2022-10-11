package com.chenzhen.blog.mapper;

import com.chenzhen.blog.pojo.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author MIS
* @description 针对表【t_message】的数据库操作Mapper
* @createDate 2022-09-11 18:21:11
* @Entity com.chenzhen.blog.pojo.Message
*/
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

    List<Message> getMessageList();

    int saveMessage(Message message);

    List<Message> getReplyList(@Param("rootMessageId") Long rootMessageId);

}




