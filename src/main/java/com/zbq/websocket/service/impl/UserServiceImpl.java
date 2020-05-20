package com.zbq.websocket.service.impl;

import com.zbq.websocket.dao.UserDao;
import com.zbq.websocket.entity.UserEntity;
import com.zbq.websocket.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public UserEntity LoginPD(UserEntity userInfo) {
		return userDao.LoginPD(userInfo);
	}

	@Override
	public UserEntity selectUserName(UserEntity userInfo) {
		return userDao.selectUserName(userInfo);
	}

	@Override
	public UserEntity getUserInfo(UserEntity userInfo) {
		// TODO Auto-generated method stub
		return userDao.getUserInfo(userInfo);
	}

	@Override
	public void saveUser(UserEntity userInfo) {
		userDao.saveUser(userInfo);
	}

	/*@Override
	public UserInfo findUserInfoByCookiePhone(String phone) {
		// TODO Auto-generated method stub
		return userInfoDao.findUserInfoByCookiePhone(phone);
	}
	
	//查询注册是否重复
	@Override
	public UserInfo QueryIsrePeated(String phone) {
		// TODO Auto-generated method stub
		return userInfoDao.QueryIsrePeated(phone);
	}


	@Override
	public UserInfo Userinfo(Integer userId) {
		// TODO Auto-generated method stub
		return userInfoDao.Userinfo(userId);
	}
*/
}
