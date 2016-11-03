
/** 
 * Project Name:demo-auth 
 * File Name:ApplicationMvcConfig.java
 * Package Name:com.example.config
 * Date:下午8:01:58
 * Copyright (c) 2016,qinjet@gmail.com All Rights Reserved. 
 * 
 */

package io.github.jetqin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author jet
 *
 */

@Configuration
@EnableWebMvc
public class ApplicationMvcConfig extends WebMvcConfigurerAdapter
{
  
    /* (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureMessageConverters(java.util.List)
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
}
