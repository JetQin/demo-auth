///** 
// * Project Name:demo-auth 
// * File Name:JpaEntityRepository.java 
// * Package Name:io.github.jetqin.repository
// * Date:Nov 4, 20161:27:29 PM 
// * Copyright (c) 2016, jetq All Rights Reserved. 
// * 
// */
//package io.github.jetqin.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.ParameterMode;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.persistence.StoredProcedureQuery;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import io.github.jetqin.DemoAuthApplication;
//import io.github.jetqin.domain.Result;
//
///**
// * ClassName: JpaEntityRepository
// * 
// * @author jet
// * @version Configuration Framework 1.0
// * @since JDK 1.7
// */
//@Repository
//public class JpaEntityRepository
//{
//
//  private static final Logger log = LoggerFactory.getLogger(JpaEntityRepository.class);
//
//  @PersistenceContext // (unitName="JpaEntityRepository")
//  EntityManager               em;
//
//  @Transactional(propagation = Propagation.REQUIRED)
//  public void loadResult ( )
//  {
//    StoredProcedureQuery query = em.createStoredProcedureQuery("LOADOPERATEDMONTHLYPROD");
//    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.OUT);
//    query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
//    query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.OUT);
//    query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
//    query.executeUpdate();
//
//    int loadCount = (int) query.getOutputParameterValue(1);
//    int newCount = (int) query.getOutputParameterValue(2);
//    int failedCount = (int) query.getOutputParameterValue(3);
//    String message = (String) query.getOutputParameterValue(4);
//
//    System.out.println(String.format("load count: %d,new count:%d,failed count:%d,message:%s", loadCount, newCount,
//        failedCount, message));
//
//  }
//
//  /**
//   * NamedQuery
//   */
//  @Transactional(propagation = Propagation.REQUIRED)
//  public void testNamedQuery ( )
//  {
//    log.info("test named query");
//    Query query = em.createNamedQuery("load");
//    query.setParameter("message", "{123");
//    List<Result> datas = query.getResultList();
//    for (Result data : datas)
//    {
//      System.out.println(data);
//    }
//  }
//
//  /**
//   * NativeSQLQuery
//   */
//  @Transactional(propagation = Propagation.REQUIRED)
//  public void testNativeSQLQuery ( )
//  {
//    log.info("test native sql query");
//    Query query = em.createNamedQuery("loadQuery");
//    query.setParameter(1, "{123");
//    List<Result> datas = query.getResultList();
//    for (Result data : datas)
//    {
//      System.out.println(data);
//    }
//  }
//
//  /**
//   * SQLQuery
//   */
//  @Transactional(propagation = Propagation.REQUIRED)
//  public void testSQLQuery ( )
//  {
//    log.info("test sql query");
//    StringBuffer sql = new StringBuffer();
//    sql.append("SELECT MESSAGE,LOAD_COUNT,FAILED_COUNT,NEW_COUNT FROM RESULT WHERE MESSAGE LIKE ");
//    sql.append(" concat(char(123),'%') ");
//    Query query = em.createNativeQuery(sql.toString());
//    List datas = query.getResultList();
//    for (Object data : datas)
//    {
//      System.out.println(data.toString());
//    }
//  }
//}
