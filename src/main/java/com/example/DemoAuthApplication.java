package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@Import(value={WebSecurityConfig.class})
@ComponentScan(basePackages="com.example.*")
public class DemoAuthApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(DemoAuthApplication.class, args);
	}
}
