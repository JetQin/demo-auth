package io.github.jetqin.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STOCKS")
public @Data class Stock implements Serializable
{

  /**
   * 
   */
  private static final long serialVersionUID = 7713678220207617005L;

  // code,代码
  @Id
  @Column(name = "code", length = 6)
  private String code;

  // name,名称
  @Column(name = "name")
  private String name;

  // industry,所属行业
  @Column(name = "INDUSTRY")
  private String industry;

  // area,地区
  @Column(name = "area")
  private String area;

  // pe,市盈率
  @Column(name = "PE")
  private BigDecimal pe;

  // outstanding,流通股本(亿)
  @Column(name = "OUTSTANDING")
  private BigDecimal outstanding;

  // totals,总股本(亿)
  @Column(name = "TOTALS")
  private BigDecimal totals;

  // totalAssets,总资产(万)
  @Column(name="TOTALASSETS")
  private BigDecimal totalAssets;
  
  // liquidAssets,流动资产
  @Column(name="LIQUIDASSETS")
  private BigDecimal liquidAssets;
  
  // fixedAssets,固定资产
  @Column(name="FIXEDASSETS")
  private BigDecimal fixedAssets;
  
  // reserved,公积金
  @Column(name="RESERVED")
  private BigDecimal reserved;
  
  // reservedPerShare,每股公积金
  @Column(name="RESERVEDPERSHARE")
  private BigDecimal reservedPerShare;
  
  // esp,每股收益
  @Column(name="ESP")
  private BigDecimal esp;
  
  // bvps,每股净资
  @Column(name="BVPS")
  private BigDecimal bvps;
  
  // pb,市净率
  @Column(name="PB")
  private BigDecimal pb;
  
  // timeToMarket,上市日期
  @Column(name="TIMETOMARKET")
  private String timeToMarket;
  
  // undp,未分利润
  @Column(name="UNDP")
  private BigDecimal undp;
  
  // perundp, 每股未分配
  @Column(name="PERUNDP")
  private BigDecimal perundp;
  
  // rev,收入同比(%)
  @Column(name="REV")
  private BigDecimal rev;
  
  // profit,利润同比(%)
  @Column(name="PROFIT")
  private BigDecimal profit;
  
  // gpr,毛利率(%)
  @Column(name="GPR")
  private BigDecimal gpr;
  
  // npr,净利润率(%)
  @Column(name="NPR")
  private BigDecimal npr;
  
  // holders,股东人数
  @Column(name="HOLDERS")
  private BigDecimal holders;
  
  
  @Override
  public String toString ( )
  {
    return String.format("Stock[code=%s,name=%s,area=%s]", code,name,area);
  }

}
