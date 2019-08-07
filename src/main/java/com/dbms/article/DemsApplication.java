package com.dbms.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = "com.dbms")
@EnableTransactionManagement(proxyTargetClass = true)
public class DemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemsApplication.class, args);
	}
}
