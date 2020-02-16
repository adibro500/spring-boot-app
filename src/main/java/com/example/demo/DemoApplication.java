package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controllers.Rest2Controller;
import com.example.controllers.RestIndController;
import com.example.model.SayHello;
import com.example.repositories.SayHelloRepository;
import com.example.services.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.context.ConfigurableApplicationContext;
//import com.example.controllers.RestIndController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.beans.factory.annotation.Autowired;
@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"com.example.repositories"})
@ComponentScan(basePackages={"com.example.repositories"})
@EntityScan(basePackageClasses=SayHello.class)

public class DemoApplication {
	
	public static void main(String[] args) {
	ConfigurableApplicationContext sc =	SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public RestIndController getRestIndController() {
		return new RestIndController();
	}

	@Bean
	public SayHello getSayHello() {
		return new SayHello();
	}
	
	@Bean
	public Rest2Controller getRest2Controller() {
		return new Rest2Controller();
	}

	@Bean
	public SayHelloService getSayHelloService() {
		return new SayHelloService();
	}
}
