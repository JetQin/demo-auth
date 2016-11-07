package io.github.jetqin.config.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.support.http.WebStatFilter;

@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*", initParams = {
    @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") })
public class DruidStatFilter extends WebStatFilter
{

  private static final Logger log = LoggerFactory.getLogger(DruidStatFilter.class);

  public DruidStatFilter ()
  {
    log.info("DruidStatFilter");
  }
}
