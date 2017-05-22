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
import io.github.jetqin.repository.JpaEntityRepository;
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
  public CommandLineRunner demo (JpaEntityRepository repository)
  {
    return (args) ->
    {

//      Presult result = repository.findOne(1);
//      Assert.notNull(result);
//       repository.loadResult();
      repository.testNamedQuery();
      repository.testNativeSQLQuery();
      repository.testSQLQuery();
      log.info("command line runner");
    };
  }

}
