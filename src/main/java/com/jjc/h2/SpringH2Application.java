package com.jjc.h2;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringH2Application.class, args);
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public void inMemoryH2DatabaseServer() throws SQLException {
		Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	}
}
