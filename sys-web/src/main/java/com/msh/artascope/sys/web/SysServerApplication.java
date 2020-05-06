package com.msh.artascope.sys.web;

import com.alibaba.fastjson.parser.ParserConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@SpringBootApplication
@ComponentScan("com.msh.artascope.sys")
@MapperScan(basePackages = "com.msh.artascope.sys.service.dao")
@EnableTransactionManagement
@EnableFeignClients("com.msh.artascope.sys")
@EnableEurekaClient
public class SysServerApplication{
	public static void main(String[] args) throws Exception {
		ParserConfig.getGlobalInstance().addAccept("com.msh.artascope.sys.");
		/**
		 * 程序启动入口
		 * 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		 */
		try {
			SpringApplication.run(SysServerApplication.class, args);
		}catch (Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
