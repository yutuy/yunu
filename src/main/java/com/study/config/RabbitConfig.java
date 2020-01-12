/*
package com.study.config;


import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Configuration
public class RabbitConfig {

	@Value("${spring.rabbitmq.host}")
	String address;
	@Value("${spring.rabbitmq.port}")
	Integer port;
	@Value("${spring.rabbitmq.username}")
	String username;
	@Value("${spring.rabbitmq.password}")
	String password;
	@Value("${mq.rabbit.virtualHost}")
	String mqRabbitVirtualHost;

	//创建mq连接
	@Bean(name = "connectionFactory")
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setPort(port);

		//connectionFactory.setVirtualHost(mqRabbitVirtualHost);
		//connectionFactory.setPublisherConfirms(true);
		//该方法配置多个host，在当前连接host down掉的时候会自动去重连后面的host
		connectionFactory.setAddresses(address);
		return connectionFactory;
	}

}
*/
