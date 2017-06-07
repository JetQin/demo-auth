package io.github.jetqin.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

public @Data class StockCurrent implements Serializable
{

  /**
   * 
   */
  private static final long serialVersionUID = 7713678220207617005L;

  @Id
  private String            index;

  // code：代码
  @Column(name = "CODE",length=6)
  private String            code;

  // name:名称
  private String            name;
  // changepercent:涨跌幅
  // trade:现价
  // open:开盘价
  // high:最高价
  // low:最低价
  // settlement:昨日收盘价
  // volume:成交量
  // turnoverratio:换手率
  // amount:成交量
  // per:市盈率
  // pb:市净率
  // mktcap:总市值
  // nmc:流通市值

}
