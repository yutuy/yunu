package com.study;

import javax.servlet.ServletContext;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.ServletContextAware;

/**
 * 启动类
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.study.mapper")
@EnableCaching(proxyTargetClass=true)
public class App extends SpringBootServletInitializer implements CommandLineRunner, ServletContextAware {
	
	@Value("${server.context-path}")
	private String contextPath;

	/**
	 * 将springboot打成war包必须配置
	 */
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// 初始化字典数据
		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setAttribute("contextPath", contextPath);
	}
}
