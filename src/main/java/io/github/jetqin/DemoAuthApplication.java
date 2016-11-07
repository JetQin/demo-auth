package io.github.jetqin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import io.github.jetqin.config.DruidDataSourceConfig;
import io.github.jetqin.config.PersistenceConfig;
import io.github.jetqin.config.WebSecurityConfig;
import io.github.jetqin.repository.ResultRepository;

@SpringBootApplication
@Import(value = { WebSecurityConfig.class, DruidDataSourceConfig.class, PersistenceConfig.class })
@ComponentScan(basePackages = "io.github.jetqin.*")
public class DemoAuthApplication
{

  private static final Logger log = LoggerFactory.getLogger(DemoAuthApplication.class);

  public static void main (String[] args)
  {
    SpringApplication.run(DemoAuthApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo (ResultRepository repository)
  {
    return (args) ->
    {
      log.info("command line runner");
    };
  }

}
