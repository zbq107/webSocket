package com.zbq.websocket;

import com.zbq.websocket.controller.MyWebSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebsocketApplication {

    public static void main(String[] args) {
        //SpringApplication.run(WebsocketApplication.class, args);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebsocketApplication.class, args);
        MyWebSocket.setApplicationContext(applicationContext);
    }

}
