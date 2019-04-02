package com.thd.webtest.service;

import org.apache.activemq.ActiveMQConnection;

public class MQCfg {
	//例子:https://www.cnblogs.com/zhuxiaojie/p/5564187.html
	
	// 发送次数
    public static int SEND_NUM = 5;
    // tcp 地址
    public static String BROKER_URL = "tcp://127.0.0.1:61616";
    // 目标，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp
    public static String DESTINATION = "sagedragon.mq.queue";
    //ActiveMQ 用户名
    public static String USER_NAME = ActiveMQConnection.DEFAULT_USER;
    //ActiveMQ 密码
    public static String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    
    
    
    
}
