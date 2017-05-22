package io.github.jetqin.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DruidHandler implements HandlerInterceptor
{
  private static final Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);

  @Override
  public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
  {
    log.info("prehandler druid");
    response.addHeader("Content-Type","text/html; charset=utf-8");
    return true;
  }

  @Override
  public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception
  {
    log.info("prehandler druid");
    response.addHeader("Content-Type","text/html; charset=utf-8");
    
  }

  @Override
  public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception
  {
    
  }

}
