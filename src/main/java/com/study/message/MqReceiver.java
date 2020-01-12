//package com.study.message;
//
//
////import groovy.util.logging.Slf4j;
//import groovy.util.logging.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.QueueBinding;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//import sun.util.logging.resources.logging;
//
///**
// * 接收mq消息
// * @author antma
// */
//@Slf4j
//@Component
//public class MqReceiver {
//
//    private final static Logger log = LoggerFactory.getLogger(MqReceiver.class);
//
////    //1. 手动创建，需在RabbitMQ中手动创建myQueue1 队列，否则报错
////    @RabbitListener(queues = "myQueue1")
////    public void process1(String message){
////        log.info("MqReceiver1: {}", message);
////    }
////
////    //2. 自动创建队列
////    @RabbitListener(queuesToDeclare = @Queue("myQueue2"))
////    public void process2(String message){
////        log.info("MqReceiver2: {}", message);
////
////    }
//
//    //3. 自动创建队列，Exchange 与 Queue绑定
////    @RabbitListener(bindings = @QueueBinding(
////            value = @Queue("myQueue3"),
////            exchange = @Exchange("testExChange")
////    ))
//    public void process3(String message){
//        log.info("MqReceiver3: {}", message);
//    }
//
//
////    @RabbitListener(bindings = @QueueBinding(
////            exchange = @Exchange("myOrder"),
////            key = "computer",
////            value = @Queue("computerOrder")
////    ))
////    public void processComputer(String message){
////        log.info("computer MqReceiver: {}", message);
////
////    }
////
////    @RabbitListener(bindings = @QueueBinding(
////            exchange = @Exchange("myOrder"),
////            key = "fruit",
////            value = @Queue("fruitOrder")
////    ))
////    public void processFruit(String message){
////        log.info("fruit MqReceiver: {}", message);
////
////    }
//
//}