///** 
// * Project Name:demo-auth 
// * File Name:AuthUserDetailService.java 
// * Package Name:com.example.config
// * Date:Oct 27, 20162:54:06 PM 
// * Copyright (c) 2016, jetq All Rights Reserved. 
// * 
// */
//package com.example.config;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * ClassName: AuthUserDetailService
// * 
// * @author jet
// * @version Configuration Framework 1.0
// * @since JDK 1.7
// */
//@Component
//public class AuthUserDetailService implements UserDetailsService
//{
//
//  /*
//   * (non-Javadoc)
//   * 
//   * @see org.springframework.security.core.userdetails.UserDetailsService#
//   * loadUserByUsername(java.lang.String)
//   */
//  @Override
//  public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException
//  {
//    // TODO Auto-generated method stub
//    return new User("admin", "admin", getAuthorities());
//  }
//
//  private List<GrantedAuthority> getAuthorities ( )
//  {
//    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//    return authorities;
//  }
//
//}
