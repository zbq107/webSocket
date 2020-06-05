package com.zbq.websocket.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class UserEntity {
    private Long id;
    //用户名
    private String userName;
    //密码
    private String passWord;
    //头像
    private String headPhoto;
    //地址
    private String site;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //是否可用
    private String enable;
    
}
