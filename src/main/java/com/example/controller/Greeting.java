/** 
 * Project Name:demo-auth 
 * File Name:Greeting.java 
 * Package Name:com.example.controller
 * Date:Oct 27, 201611:14:47 AM 
 * Copyright (c) 2016, jetq All Rights Reserved. 
 * 
 */
package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
  @PreAuthorize(value = " /hasAuthority('ADMIN')")
  @RequestMapping("/greeting")
  @ResponseBody
  public String greeting ()
  {
    return "Hello World";
  }
  
  @PreAuthorize(value = " /hasAuthority('USER')")
    @RequestMapping("/hello")
    @ResponseBody
    public String hello ()
    {
      return "I said hello";
    }
}
