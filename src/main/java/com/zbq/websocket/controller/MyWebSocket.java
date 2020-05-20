package com.zbq.websocket.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zbq.websocket.entity.ChattingRecordsEntity;
import com.zbq.websocket.entity.UserEntity;
import com.zbq.websocket.service.ChattingRecordService;
import com.zbq.websocket.service.UserService;
import com.zbq.websocket.util.JsonUtils;
import com.zbq.websocket.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
  * @Description: websocket的具体实现类
  * 使用springboot的唯一区别是要@Component声明下，而使用独立容器是由容器自己管理websocket的，
  * 但在springboot中连容器都是spring管理的。
      虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，
      所以可以用一个静态set保存起来。
  */
@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocket {
     //用来存放每个客户端对应的MyWebSocket对象。
     private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
     //与某个客户端的连接会话，需要通过它来给客户端发送数据
     private Session session;

     //解决service注入的问题
     private static ApplicationContext applicationContext;
     public static void setApplicationContext(ApplicationContext context) {
          applicationContext = context;
     }

      //private static UserService userService;
      //@Autowired
      //public static void setUserService(UserService userService) {
      //     MyWebSocket.userService = userService;
      //}

     /**
       * 连接建立成功调用的方法
       */
     @OnOpen
     public void onOpen(Session session) {
          this.session = session;
          webSocketSet.add(this);      //加入set中
          System.out.println("有新连接加入！当前在线人数为" + webSocketSet.size());
          JSONObject json = new JSONObject();
          json.put("sessionId",session.getId());
          json.put("message","恭喜您成功连接上WebSocket");
          json.put("onlineCount",webSocketSet.size());
          String message = JsonUtils.GsonString(json);
          this.session.getAsyncRemote().sendText(message);
          //this.session.getAsyncRemote().sendText("恭喜您成功连接上WebSocket-->当前在线人数为："+webSocketSet.size());
     }
     /**
       * 连接关闭调用的方法
       */
     @OnClose
     public void onClose() {
          webSocketSet.remove(this);  //从set中删除
          //新加一个，当后台返回连接关闭，清除掉前端的连接状态,感觉没必要
          //群发消息
          //broadcast("json.toString()");
          System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
     }
     /**
       * 收到客户端消息后调用的方法
       *
       * @param message 客户端发送过来的消息*/
     @OnMessage
     public void onMessage(String message, Session session) {
           /*Map<String,Object> map = JsonUtils.GsonToMaps(message);
           map.get("userID");
           map.get("message");*/
           //在这个位置接受信息，然后存到数据库
          ChattingRecordsEntity cre = JSON.parseObject(message, ChattingRecordsEntity.class);
          System.out.println("来自客户端的消息:" + cre.getMsg());
          JSONObject json = new JSONObject();
          json = JSONObject.parseObject(message);
          //查询用户信息
          UserService userService = applicationContext.getBean(UserService.class);
          UserEntity ue = new UserEntity();
          ue.setUserName(cre.getUserName());
          UserEntity userEntity = userService.getUserInfo(ue);
          if (null != userEntity && null != userEntity.getHeadPhoto() && !"".equals(userEntity.getHeadPhoto())){
               json.put("headPhoto",userEntity.getHeadPhoto());
          }
          //chattingRecordService.saveChattingRecord(cre);
          //群发消息
          broadcast(json.toString());
     }
     /**
       * 发生错误时调用
       *
       */
     @OnError
     public void onError(Session session, Throwable error) {
          System.out.println("发生错误");
          error.printStackTrace();
     }
     /**
       * 群发自定义消息
       * */
     public  void broadcast(String message){
          for (MyWebSocket item : webSocketSet) {
               //同步异步说明参考：http://blog.csdn.net/who_is_xiaoming/article/details/53287691
               //this.session.getBasicRemote().sendText(message);
              //item.session.getAsyncRemote().sendText(message);//异步发送消息.
              item.session.getAsyncRemote().sendText(message);
          }
     }
}