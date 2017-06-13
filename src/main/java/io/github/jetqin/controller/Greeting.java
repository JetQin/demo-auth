/** 
 * Project Name:demo-auth 
 * File Name:Greeting.java 
 * Package Name:com.example.controller
 * Date:Oct 27, 201611:14:47 AM 
 * Copyright (c) 2016, jetq All Rights Reserved. 
 * 
 */

package io.github.jetqin.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: Greeting
 * 
 * @author jet
 * @version Configuration Framework 1.0
 * @since JDK 1.7
 */
@Controller
public class Greeting
{

  // @PreAuthorize(value = " /hasAuthority('ADMIN')")
  @RequestMapping("/greeting")
  @ResponseBody
  public String greeting ( )
  {
    return "Hello World";
  }

  // @PreAuthorize(value = " /hasAuthority('USER')")
  @RequestMapping("/hello")
  @ResponseBody
  public ModelAndView hello (HttpServletResponse resp )
  {
    //      resp.sendRedirect("http://baidu.com");
//          resp.setHeader( "Location", "https://baidu.com" );
//          resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//    return "forward:/sso.html";
    
//    ModelAndView mv = new ModelAndView();
//    mv.setViewName("sso");
//    return mv;
    return new ModelAndView("redirect:sso.html");
  }

  @RequestMapping("/getDate")
  @ResponseBody
  public Date getDate ( )
  {
    return new Date();
  }

  @PreAuthorize(value = " /hasAuthority('USER')")
  @RequestMapping("/page")
  @ResponseBody
  public PageRequest getPageQuery (PageRequest query)
  {
    System.out.println(query);
    return new PageRequest(0, 100);
  }

  @RequestMapping("/login")
  @ResponseBody
  public ModelAndView login ( )
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("login");
    return mv;
  }

}
