/** 
 * Project Name:demo-auth 
 * File Name:JpaEntityRepository.java 
 * Package Name:io.github.jetqin.repository
 * Date:Nov 4, 20161:27:29 PM 
 * Copyright (c) 2016, jetq All Rights Reserved. 
 * 
 */
package io.github.jetqin.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 * ClassName: JpaEntityRepository
 * 
 * @author jet
 * @version Configuration Framework 1.0
 * @since JDK 1.7
 */
@Repository
public class JpaEntityRepository
{

//  @Autowired
  @PersistenceContext//(unitName="JpaEntityRepository")
  EntityManager em;


  @Transactional(propagation=Propagation.REQUIRED)
  public void loadResult ( )
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery("LOADOPERATEDMONTHLYPROD");
    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
    query.executeUpdate();

    int loadCount = (int) query.getOutputParameterValue(1);
    int newCount = (int) query.getOutputParameterValue(2);
    int failedCount = (int) query.getOutputParameterValue(3);
    String message = (String) query.getOutputParameterValue(4);

    System.out.println(String.format("load count: %d,new count:%d,failed count:%d,message:%s", loadCount, newCount,
        failedCount, message));

  }
}
