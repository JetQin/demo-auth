package io.github.jetqin.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class StockHistoryID implements Serializable
{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1538220610685562367L;


  private String date;
  
  private String code;
  
}
