package io.github.jetqin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import io.github.jetqin.config.WebSecurityConfig;

@SpringBootApplication
@Import(value={WebSecurityConfig.class})
@ComponentScan(basePackages="io.github.jetqin.*")
public class DemoAuthApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(DemoAuthApplication.class, args);
	}
}
