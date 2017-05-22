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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

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
  @RequestMapping ("/greeting")
  @ResponseBody
  public String greeting ()
  {
    return "Hello World";
  }

  // @PreAuthorize(value = " /hasAuthority('USER')")
  @RequestMapping ("/hello")
  @ResponseBody
  public String hello ()
  {
    return "I said hello";
  }

  @RequestMapping ("/getDate")
  @ResponseBody
  public Date getDate ()
  {
    return new Date();
  }

  @PreAuthorize(value = " /hasAuthority('USER')")
  @RequestMapping("/page")
  @ResponseBody
  public PageRequest getPageQuery(PageRequest query)
  {
    System.out.println(query);
    return new PageRequest(0,100);
  }
  
  @RequestMapping("/index")
  public ModelAndView index(@RequestParam(value="name", required=false, defaultValue="World") String name) {
      ModelAndView mv = new ModelAndView();
      mv.addObject("name", "Jet Qin");
      mv.setViewName("index");
      return mv;
  }
  

  
  
//  @RequestMapping("/index")
//  public String index() {
//    return "index";
//  }
  
  @RequestMapping ("/login")
  @ResponseBody
  public ModelAndView login ()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("login");
    return mv;
  }

}
