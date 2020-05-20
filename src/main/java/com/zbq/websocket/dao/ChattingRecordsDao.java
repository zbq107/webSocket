package com.zbq.websocket.dao;

import com.zbq.websocket.entity.ChattingRecordsEntity;
import com.zbq.websocket.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChattingRecordsDao {

    //获取所有的聊天记录
    List<ChattingRecordsEntity> getAllChattingRecords();
    //保存聊天记录
    void saveChattingRecord(ChattingRecordsEntity chattingRecordsEntity);

}
