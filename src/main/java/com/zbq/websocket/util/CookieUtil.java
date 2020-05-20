package com.zbq.websocket.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	public static void addCookie(String name,String value,String path,int maxAge,HttpServletResponse response) {
		
		//创建cookie
		Cookie cookie = new Cookie(name, value);
		//设置路径
		cookie.setPath(path);
		//生命周期
		cookie.setMaxAge(maxAge);
		//生成cookie
		response.addCookie(cookie);
		
	}
	
	//取cookie
	public static String getValue(String name,HttpServletRequest request) {
		
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					value = cookie.getValue();
				}
			}
		}
		return value;
		
	}
	
	
	

}
