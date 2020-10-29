package com.hz.research.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSON;
import com.hz.research.model.WebSocketMapUtil;
import org.apache.log4j.Logger;


@ServerEndpoint(value = "/websocket")
public class MyWebSocketServer {
    private Logger logger = Logger.getLogger(MyWebSocketServer.class);
    private Session session;

    /**
     * 连接建立后触发的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        logger.info("onOpen" + session.getId());
        WebSocketMapUtil.put(session.getId(), this);
    }

    /**
     * 连接关闭后触发的方法
     */
    @OnClose
    public void onClose() {
        //从map中删除
        WebSocketMapUtil.remove(session.getId());
        logger.info("====== onClose:" + session.getId() + " ======");
    }

    /**
     * 接收到客户端消息时触发的方法
     */
    @OnMessage
    public void onMessage(String params, Session session) throws Exception {
        //获取服务端到客户端的通道
        MyWebSocketServer myWebSocket = WebSocketMapUtil.get(session.getId());
        logger.info("收到来自" + session.getId() + "的消息" + params);
        String result = "收到来自" + session.getId() + "的消息" + params;
        //返回消息给Web Socket客户端（浏览器）
        myWebSocket.sendMessage(1, "成功！", result);
    }

    /**
     * 发生错误时触发的方法
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.info(session.getId() + "连接发生错误" + error.getMessage());
        error.printStackTrace();
    }

    public void sendMessage(int status, String message, Object datas) throws IOException {
        Map<String,Object> result = new HashMap<>();
        result.put("status", status);
        result.put("message", message);
        result.put("datas", datas);
        this.session.getBasicRemote().sendText(JSON.toJSONString(result));
    }

}