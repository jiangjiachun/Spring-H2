package com.jjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringH2Application.class, args);
	}

	/*
	@Bean(initMethod = "start", destroyMethod = "stop")
	public void databaseServer() throws SQLException {
		Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	}*/
	
}
