package io.github.jetqin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import io.github.jetqin.config.ApplicationMvcConfig;
import io.github.jetqin.config.DruidDataSourceConfig;
import io.github.jetqin.config.PersistenceConfig;
import io.github.jetqin.config.WebSecurityConfig;

@SpringBootApplication
@Import(value = {ApplicationMvcConfig.class,WebSecurityConfig.class, DruidDataSourceConfig.class, PersistenceConfig.class })
@ComponentScan(basePackages = "io.github.jetqin.*")
public class DemoAuthApplication extends SpringBootServletInitializer
{

  private static final Logger log = LoggerFactory.getLogger(DemoAuthApplication.class);

  @Override
  protected SpringApplicationBuilder configure (SpringApplicationBuilder application)
  {
    return application.sources(DemoAuthApplication.class);
  }

  public static void main (String[] args)
  {
    SpringApplication.run(DemoAuthApplication.class, args);
    log.info("[Application Startup]");
  }

}
