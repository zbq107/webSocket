package com.zbq.websocket.dao;

import com.zbq.websocket.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
	
	//登录判定
	UserEntity LoginPD(UserEntity userInfo);

	//注册查询用户名
	UserEntity selectUserName(UserEntity userInfo);

	//查询用户所有信息
	UserEntity getUserInfo(UserEntity userInfo);

	//添加用户
	void saveUser(UserEntity userInfo);

	/*//自动登录 根据cookie中的手机号查询用户对象
	UserInfo findUserInfoByCookiePhone(String phone);
	
	//根据id查询用户信息
	UserInfo Userinfo(Integer userId);
	
	//更新密码
    void updateUserPassword(UserInfo userInfo); 
 
    //查询注册是否重复
  	UserInfo QueryIsrePeated(String phone);
	
	List<UserInfo> findAll();*/
}
