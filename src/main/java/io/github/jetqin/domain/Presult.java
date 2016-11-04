/** 
 * Project Name:demo-auth 
 * File Name:Result.java 
 * Package Name:io.github.jetqin.domain
 * Date:Nov 4, 201611:39:28 AM 
 * Copyright (c) 2016, jetq All Rights Reserved. 
 * 
 */
package io.github.jetqin.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Data;

/**
 * ClassName: Result
 * 
 * @author jet
 * @version Configuration Framework 1.0
 * @since JDK 1.7
 */

@Entity
@Table(name = "PRESULT")
@NamedStoredProcedureQueries(
      @NamedStoredProcedureQuery(name = "Presult.findLoadResult",procedureName="LOADOPERATEDMONTHLYPROD",resultClasses={Presult.class},
      parameters={ 
          @StoredProcedureParameter(name="LOAD_COUNT",mode=ParameterMode.OUT,type=Integer.class),
          @StoredProcedureParameter(name="NEW_COUNT",mode=ParameterMode.OUT,type=Integer.class),
          @StoredProcedureParameter(name="FAILED_COUNT",mode=ParameterMode.OUT,type=Integer.class),
          @StoredProcedureParameter(name="MESSAGE",mode=ParameterMode.OUT,type=String.class)
      })
    )
public @Data class Presult implements Serializable
{
  @Id
  @Column(name = "LOAD_COUNT")
  private int    loadCount;

  @Column(name = "NEW_COUNT")
  private int    newCount;

  @Column(name = "FAILED_COUNT")
  private int    failedCount;

  @Column(name = "MESSAGE")
  private String message;
  
  public String toString(){
    return String.format("load count: %d,new count:%d,failed count:%d,message:%s", loadCount,newCount,failedCount,message);
  }
}
