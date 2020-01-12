package com.example.yut.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

//消费者
public class Receiver {

    public static void main(String args[]){

        Receiver receiver = new Receiver();
        receiver.receiverMessage();
    }

    public void receiverMessage(){

        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session =null;

        try {
            //1.创建连接工厂
            connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            //2.得到一个连接
            connection = connectionFactory.createConnection();
            //3.创建一个Session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //4.创建目的地
            Destination destination = session.createQueue("myQueue");
            //5.创建接受者
            MessageConsumer messageConsumer = session.createConsumer(destination);
            //6.打开连接
            connection.start();
            //7.接收消息
            TextMessage textMessage = (TextMessage) messageConsumer.receive(1000);
            //8.输出验证
            System.out.println("接收到的消息为:"+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection !=null) {
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