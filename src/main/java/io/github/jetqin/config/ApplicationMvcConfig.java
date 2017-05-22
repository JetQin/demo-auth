
/** 
 * Project Name:demo-auth 
 * File Name:ApplicationMvcConfig.java
 * Package Name:com.example.config
 * Date:下午8:01:58
 * Copyright (c) 2016,qinjet@gmail.com All Rights Reserved. 
 * 
 */

package io.github.jetqin.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import io.github.jetqin.config.interceptor.DruidHandler;

/**
 * @author jet
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="io.github.jetqin.controller")
public class ApplicationMvcConfig extends WebMvcConfigurerAdapter
{

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#
   * configureMessageConverters(java.util.List)
   */
  @Override
  public void configureMessageConverters (List<HttpMessageConverter<?>> converters)
  {
    // TODO Auto-generated method stub
    super.configureMessageConverters(converters);

    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.simpleDateFormat("mm/dd/yyyy");
    converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
  }
 
  
  @Override
  public void addResourceHandlers (ResourceHandlerRegistry registry)
  {
    registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
    registry.addResourceHandler("/druid/**").addResourceLocations("classpath:/support.http.resources/");
  }
  
  @Override
  public void addInterceptors (InterceptorRegistry registry)
  {
    registry.addInterceptor(new DruidHandler()).addPathPatterns("/**");
  }
  
  
  @Bean
  public HandlerExceptionResolver exceptionResolver ( )
  {
    SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
    exceptionResolver.addStatusCode("404", HttpStatus.NOT_FOUND.value());
    exceptionResolver.addStatusCode("401", HttpStatus.UNAUTHORIZED.value());
    return exceptionResolver;
  }
  
  
}
