
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import io.github.jetqin.config.interceptor.AppHandler;
import io.github.jetqin.config.interceptor.DruidHandler;

/**
 * @author jet
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "io.github.jetqin.controller")
public class ApplicationMvcConfig extends WebMvcConfigurerAdapter
{

  @Autowired
  Environment env;

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.config.annotation.
   * WebMvcConfigurerAdapter# configureMessageConverters(java.util.List)
   */
  @Override
  public void configureMessageConverters (List<HttpMessageConverter<?>> converters)
  {
    // TODO Auto-generated method stub
    super.configureMessageConverters(converters);

    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.simpleDateFormat("dd/mm/yyyy");
    converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    converters.add(new StringHttpMessageConverter());
  }

  @Override
  public void addViewControllers (ViewControllerRegistry registry)
  {
    registry.addViewController("/").setViewName("index.html");
    registry.addRedirectViewController("/error", "/error/error.html");
    registry.addViewController("/404").setViewName("forward:/404.html");
    registry.addViewController("/500").setViewName("forward:/500.html");
    registry.addViewController("/error").setViewName("/error/error.html");
    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    super.addViewControllers(registry);

  }

  @Override
  public void addResourceHandlers (ResourceHandlerRegistry registry)
  {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/public/");
    registry.addResourceHandler("/error/**").addResourceLocations("classpath:/public/error/");
    registry.addResourceHandler("/druid/**").addResourceLocations("classpath:/support.http.resources/");
    // registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").resourceChain(true)
    // .addResolver(new
    // VersionResourceResolver().addFixedVersionStrategy("1.10", "/**/*.js")
    // .addContentVersionStrategy("/**"));
  }

  @Override
  public void addInterceptors (InterceptorRegistry registry)
  {
    registry.addInterceptor(new DruidHandler()).addPathPatterns("/druid/**");
    registry.addInterceptor(new AppHandler()).addPathPatterns("/**");
  }

  // @Bean
  // public JettyEmbeddedServletContainerFactory
  // jettyEmbeddedServletContainerFactory ( ) {
  // JettyEmbeddedServletContainerFactory jettyContainer = new
  // JettyEmbeddedServletContainerFactory();
  // jettyContainer.setContextPath(env.getProperty("server.context-path"));
  // return jettyContainer;
  // }

  @Bean
  public ViewResolver viewResolver ( )
  {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    // resolver.setPrefix(env.getProperty("server.context-path"));
    resolver.setSuffix(".html");
    return resolver;
  }

  @Override
  public void configureDefaultServletHandling (DefaultServletHandlerConfigurer configurer)
  {
    configurer.enable();
  }

  @Bean
  public HandlerExceptionResolver exceptionResolver ( )
  {
    SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
    exceptionResolver.addStatusCode("/404", HttpStatus.NOT_FOUND.value());
    exceptionResolver.addStatusCode("/401", HttpStatus.UNAUTHORIZED.value());
    exceptionResolver.addStatusCode("/500", HttpStatus.SERVICE_UNAVAILABLE.value());
    return exceptionResolver;
  }

}
