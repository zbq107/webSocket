//package com.zbq.websocket.config;
//
//import com.alibaba.fastjson.JSON;
//import com.zbq.websocket.entity.UserEntity;
//import com.zbq.websocket.util.RedisUtil;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//@Component
//public class HttpSessionValue {
//    /**
//     * 注入redis缓存工具类
//     */
//    @Resource
//    private RedisUtil redisUtil;
//
//    ///**
//    // *从Session中取出当前用户信息
//    // * @param request HttpServletRequest
//    // */
//    //public UserEntity getSessionUserAuth(HttpServletRequest request, String workArea) {
//    //    String sessionId = request.getHeader("SESSION");
//    //    if (sessionId != null && !"".equals(sessionId)) {
//    //        String result = redisUtil.get(sessionId);
//    //        if (null != result && !"".equals(result)) {
//    //            UserEntity sysUsers = JSON.parseObject(result, UserEntity.class);
//    //            if (workArea != null && !"".equals(workArea)) {
//    //                if (sysUsers.getRightRolesList() != null) {
//    //                    for (RightRoles roles:sysUsers.getRightRolesList()) {
//    //                        if (workArea.equals(roles.getWorkArea())) {
//    //                             if (null != roles.getRoleType()
//    //                                && roles.getRoleType()) {
//    //                                //sysUsers.setRoleWorkArea(workArea);
//    //                                //sysUsers.setLocalAdmin(true);
//    //                            }
//    //                        }
//    //                    }
//    //                }
//    //            }
//    //            return sysUsers;
//    //        }
//    //    }
//    //    return null;
//    //}
//
//
//    /**
//     *从Session中取出当前用户信息
//     * @param request HttpServletRequest
//     */
//    public UserEntity getSessionUser(HttpServletRequest request) {
//        String sessionId = request.getHeader("SESSION");
//       /* Cookie cookie= CookieUtil.get(request,"SESSION");
//        System.out.print("zzzzzzzzzzzsssssssssssssss"+cookie);
//        String sessionId = cookie.getValue();*/
//        //String sessionId = "f4b8d9b3-627b-49cf-800b-a1902627b5ad";
//        if (sessionId != null && !"".equals(sessionId)) {
//            String result = redisUtil.get(sessionId);
//            if (null != result && !"".equals(result)) {
//                UserEntity sysUsers = JSON.parseObject(result, UserEntity.class);
//                return sysUsers;
//            }
//        }
//        return null;
//    }
//
//    /**
//     *从Session中取出当前用户信息
//     * @param sessionId String
//     */
//    public String getSessionUser(String sessionId) {
//        if (sessionId != null && !"".equals(sessionId)) {
//            String result = redisUtil.get(sessionId);
//            if (null != result && !"".equals(result)) {
//                UserEntity sysUsers = JSON.parseObject(result, UserEntity.class);
//                return sysUsers.getUserName();
//            }
//        }
//        return null;
//    }
//
//    /**
//     *从Session中取出当前用户的sessionId
//     * @param request HttpServletRequest
//     */
//    public String getSessionId(HttpServletRequest request) {
//        String sessionId = request.getHeader("SESSION");
//        return sessionId;
//    }
//
//    /**
//     *从Session中取出当前用户的sessionId并放入redis
//     * @param request HttpServletRequest
//     */
//    public String getToken(HttpServletRequest request) {
//        String sessionId = request.getHeader("SESSION");
//        redisUtil.set("USERSESSIONID" + sessionId
//                , sessionId
//                ,1800L);
//        return sessionId;
//    }
//}
