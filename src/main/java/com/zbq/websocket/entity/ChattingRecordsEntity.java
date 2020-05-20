package com.zbq.websocket.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class ChattingRecordsEntity {

    private Long id;
    //用户id
    private String userId;
    //用户名
    private String userName;
    //聊天信息
    private String msg;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //图片地址
    private String photoUrl;
    
}
