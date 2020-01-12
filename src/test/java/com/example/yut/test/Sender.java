package com.example.yut.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

//生产者
public class Sender {

    public static void main(String args[]){

        Sender sender = new Sender();
        sender.sendMessage("hello,赵秀宝");

    }

    public void sendMessage(String msg){

        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;

        try {
            //1.创建连接工厂
            connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            //2.得到一个连接
            connection = connectionFactory.createConnection();
            //3.创建一个Session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //4.创建目的地
            Destination destination = session.createQueue("myQueue");
            //5.创建发送者
            MessageProducer messageProducer = session.createProducer(destination);
            //6.创建文本消息
            TextMessage textMessage = session.createTextMessage(msg);
            //7.发送消息
            messageProducer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }finally{
            //8.关闭connection和sessiosn
            try {
                if(connection !=null){
                    connection.close();
                }
                if (session !=null) {
                    session.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}