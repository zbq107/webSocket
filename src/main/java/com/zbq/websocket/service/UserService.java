package com.zbq.websocket.service;

import com.zbq.websocket.entity.UserEntity;


public interface UserService {

	//登录判定
	UserEntity LoginPD(UserEntity userEntity);

	//注册查询用户名
	UserEntity selectUserName(UserEntity userInfo);
	
	//查询用户信息
	UserEntity getUserInfo(UserEntity userInfo);

	//添加用户
	void saveUser(UserEntity userInfo);
	
	/*//自动登录 根据cookie中的手机号查询用户对象
	UserInfo findUserInfoByCookiePhone(String phone);

	//根据Id查询用户信息
	UserInfo Userinfo(Integer userId);

	//查询注册是否重复
	UserInfo QueryIsrePeated(String phone);*/
}
