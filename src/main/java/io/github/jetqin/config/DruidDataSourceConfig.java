package io.github.jetqin.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidDataSourceConfig
{

  // check status http://localhost:8080/druid/index.html
  @Bean
  public ServletRegistrationBean mvcServletRegister ( )
  {
    List<String> mappings = new ArrayList<String>();
    mappings.add("/druid/*");

    ServletRegistrationBean registration = new ServletRegistrationBean();
    registration.setServlet(new StatViewServlet());
    registration.setName("DruidStatView");
    registration.setUrlMappings(mappings);
    registration.addInitParameter("allow", "127.0.0.1");
    registration.addInitParameter("deny", "192.168.1.73");
    registration.addInitParameter("resetEnable", "false");

    registration.addInitParameter("loginUsername", "admin");
    registration.addInitParameter("loginPassword", "123456");
    return registration;
  }

  @Bean
  public FilterRegistrationBean mvcFilterRegister ( )
  {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new WebStatFilter());
    registration.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
    registration.addUrlPatterns("/*");
    registration.setOrder(1);
    return registration;
  }
}
