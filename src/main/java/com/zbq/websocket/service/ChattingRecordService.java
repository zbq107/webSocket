package com.zbq.websocket.service;

import com.zbq.websocket.entity.ChattingRecordsEntity;
import com.zbq.websocket.entity.UserEntity;

import java.util.List;


public interface ChattingRecordService {

	//获取所有的聊天记录
	List<ChattingRecordsEntity> getAllChattingRecords();
	//保存聊天记录
	void saveChattingRecord(ChattingRecordsEntity chattingRecordsEntity);

}
