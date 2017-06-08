package io.github.jetqin.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STOCKS_CURRENT")
public @Data class StockCurrent implements Serializable
{

  /**
   * 
   */
  private static final long serialVersionUID = 7713678220207617005L;

  @Id
  private String index;

  // code：代码
  @Column(name = "CODE", length = 6)
  private String code;

  // name:名称
  @Column(name = "NAME")
  private String name;

  // changepercent:涨跌幅
  @Column(name = "CHANGEPERCENT")
  private BigDecimal changepercent;

  // trade:现价
  @Column(name = "TRADE")
  private BigDecimal trade;

  // open:开盘价
  @Column(name = "OPEN")
  private BigDecimal open;

  // high:最高价
  @Column(name = "HIGH")
  private BigDecimal high;

  // low:最低价
  @Column(name = "LOW")
  private BigDecimal low;

  // settlement:昨日收盘价
  @Column(name = "SETTLEMENT")
  private BigDecimal settlement;

  // volume:成交量
  @Column(name = "VOLUME")
  private BigDecimal volume;

  // turnoverratio:换手率
  @Column(name = "TURNOVERRATIO")
  private BigDecimal turnoverratio;

  // amount:成交量
  @Column(name = "AMOUNT")
  private BigDecimal amount;

  // per:市盈率
  @Column(name = "PER")
  private BigDecimal PER;

  // pb:市净率
  @Column(name = "PB")
  private BigDecimal pb;

  // mktcap:总市值
  @Column(name = "MKTCAP")
  private BigDecimal mktcap;

  // nmc:流通市值
  @Column(name = "NMC")
  private BigDecimal nmc;

  @Override
  public String toString ( )
  {
    return String.format("Current Stock[name=%s,code=%s,price=%d]", name, code, trade);
  }
}
