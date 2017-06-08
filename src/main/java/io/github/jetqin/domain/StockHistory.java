package io.github.jetqin.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@IdClass(value = StockHistoryID.class)
@Table(name="STOCKS_HISTORY")
public @Data class StockHistory implements Serializable
{

  /**
   * 
   */
  private static final long serialVersionUID = -3152480950988448882L;
  
 //date：日期
  @Id
  @Column(name="DATE",length=8)
  private String date;
  
  //code: 股票编码
  @Id
  @Column(name="CODE",length=6)
  private String code;
  
//  open：开盘价
  @Column(name="OPEN")
  private BigDecimal open;
  
//  high：最高价
  @Column(name="HIGH")
  private BigDecimal high;
  
//  close：收盘价
  @Column(name="CLOSE")
  private BigDecimal close;
  
//  low：最低价
  @Column(name="LOW")
  private BigDecimal low;
  
//  volume：成交量
  @Column(name="VOLUME")
  private BigDecimal volume;
  
//  price_change：价格变动
  @Column(name="PRICE_CHANGE")
  private BigDecimal price_change;
  
//  p_change：涨跌幅
  @Column(name="P_CHANGE")
  private BigDecimal p_change;
  
//  ma5：5日均价
  @Column(name="MA_5")
  private BigDecimal ma5;
  
//  ma10：10日均价
  @Column(name="MA_10")
  private BigDecimal ma10;
  
//  ma20:20日均价
  @Column(name="MA_20")
  private BigDecimal ma20;
  
//  v_ma5:5日均量
  @Column(name="V_MA5")
  private BigDecimal v_ma5;
  
//  v_ma10:10日均量
  @Column(name="V_MA10")
  private BigDecimal v_ma10;
  
//  v_ma20:20日均量
  @Column(name="V_MA20")
  private BigDecimal v_ma20;
  
//  turnover:换手率[注：指数无此项]
  @Column(name="TURN_OVER")
  private BigDecimal turnover;

}
