
/** 
 * Project Name:demo-auth 
 * File Name:JpaConfig.java
 * Package Name:io.github.jetqin.config
 * Date:下午10:01:53
 * Copyright (c) 2016,qinjet@gmail.com All Rights Reserved. 
 * 
 */

package io.github.jetqin.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author jet
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = "io.github.jetqin.repository")
public class PersistenceConfig
{

  @Autowired
  Environment env;

  @Bean
  public DataSource dataSource ( )
  {
    // BasicDataSource dataSource = new BasicDataSource();
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
    dataSource.setUrl(env.getProperty("spring.datasource.url"));
    dataSource.setUsername(env.getProperty("spring.datasource.username"));
    dataSource.setPassword(env.getProperty("spring.datasource.password"));
//    dataSource.setMaxActive(Integer.parseInt(env.getProperty("spring.datasource.dbcp.max-active")));
    return dataSource;
    // return new
    // EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
  }

  @Bean
  public JpaTransactionManager transactionManager (EntityManagerFactory emf)
  {
    return new JpaTransactionManager(emf);
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter ( )
  {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setDatabase(Database.MYSQL);
    jpaVendorAdapter.setGenerateDdl(true);
    return jpaVendorAdapter;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory ( )
  {
    LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
    lemfb.setDataSource(dataSource());
    lemfb.setJpaVendorAdapter(jpaVendorAdapter());
    lemfb.setPackagesToScan("io.github.jetqin.domain");
    lemfb.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
    Properties jpaProperties = new Properties();
    jpaProperties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
    lemfb.setJpaProperties(jpaProperties);
    return lemfb;
  }
}
