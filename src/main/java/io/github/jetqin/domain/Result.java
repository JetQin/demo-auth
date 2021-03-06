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
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
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

//@Entity
//@Table(name = "RESULT")
@NamedStoredProcedureQueries(@NamedStoredProcedureQuery(name = "Presult.findLoadResult", procedureName = "LOADOPERATEDMONTHLYPROD", resultClasses = {
    Result.class }, parameters = {
        @StoredProcedureParameter(name = "LOAD_COUNT", mode = ParameterMode.OUT, type = Integer.class),
        @StoredProcedureParameter(name = "NEW_COUNT", mode = ParameterMode.OUT, type = Integer.class),
        @StoredProcedureParameter(name = "FAILED_COUNT", mode = ParameterMode.OUT, type = Integer.class),
        @StoredProcedureParameter(name = "MESSAGE", mode = ParameterMode.OUT, type = String.class) }))
@NamedQueries({ @NamedQuery(name = "load", query = "from Result where message = :message") })

@NamedNativeQueries({
    @NamedNativeQuery(name = "loadQuery", query = "SELECT MESSAGE,LOAD_COUNT,FAILED_COUNT,NEW_COUNT FROM RESULT WHERE MESSAGE = ?", resultClass = Result.class, resultSetMapping = "loadQueryMapping") })
@SqlResultSetMapping(name = "loadQueryMapping", entities = @EntityResult(entityClass = Result.class, fields = {
    @FieldResult(name = "message", column = "MESSAGE"), @FieldResult(name = "loadCount", column = "LOAD_COUNT"),
    @FieldResult(name = "failedCount", column = "FAILED_COUNT"),
    @FieldResult(name = "newCount", column = "NEW_COUNT") }))
public @Data class Result implements Serializable
{
  /**
   * 
   */
  private static final long serialVersionUID = 7518856229369739553L;

  @Id
  @Column(name = "LOAD_COUNT")
  private int               loadCount;

  @Column(name = "NEW_COUNT")
  private int               newCount;

  @Column(name = "FAILED_COUNT")
  private int               failedCount;

  @Column(name = "MESSAGE")
  private String            message;

  public String toString ( )
  {
    return String.format("load count: %d,new count:%d,failed count:%d,message:%s", loadCount, newCount, failedCount,
        message);
  }
}
