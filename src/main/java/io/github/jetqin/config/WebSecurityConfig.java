/** 
 * Project Name:demo-auth 
 * File Name:WebSecurityConfig.java 
 * Package Name:com.example.config
 * Date:Oct 27, 20161:08:01 PM 
 * Copyright (c) 2016, jetq All Rights Reserved. 
 * 
 */
package io.github.jetqin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * ClassName: WebSecurityConfig
 * 
 * @author jet
 * @version Configuration Framework 1.0
 * @since JDK 1.7
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

  // @Autowired
  // AuthUserDetailService authUserDetailService;

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.config.annotation.web.configuration.
   * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
   * annotation.authentication.builders.AuthenticationManagerBuilder)
   */
  @Autowired
  protected void configureGlobal (AuthenticationManagerBuilder auth) throws Exception
  {
    // TODO Auto-generated method stub
    super.configure(auth);
    auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
    auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    // auth.userDetailsService(authUserDetailService);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.config.annotation.web.configuration.
   * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
   * annotation.web.builders.HttpSecurity)
   */
  @Override
  protected void configure (HttpSecurity http) throws Exception
  {
    // TODO Auto-generated method stub
    http.csrf().disable();
//    http.headers().httpStrictTransportSecurity();
//    http.authorizeRequests().antMatchers("/greeting").hasRole("ADMIN").antMatchers("/hello").hasRole("USER").and()
//        .httpBasic();

  }

}
