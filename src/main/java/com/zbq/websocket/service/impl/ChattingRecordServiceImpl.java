package com.zbq.websocket.service.impl;

import com.zbq.websocket.dao.ChattingRecordsDao;
import com.zbq.websocket.entity.ChattingRecordsEntity;
import com.zbq.websocket.service.ChattingRecordService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ChattingRecordServiceImpl implements ChattingRecordService {

    @Resource
    private ChattingRecordsDao chattingRecordsDao;

    @Override
    public List<ChattingRecordsEntity> getAllChattingRecords() {
        return chattingRecordsDao.getAllChattingRecords();
    }

    @Override
    public void saveChattingRecord(ChattingRecordsEntity chattingRecordsEntity) {
        chattingRecordsDao.saveChattingRecord(chattingRecordsEntity);
    }
}
