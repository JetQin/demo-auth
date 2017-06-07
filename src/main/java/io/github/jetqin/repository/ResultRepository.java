///** 
// * Project Name:demo-auth 
// * File Name:ResultRepository.java 
// * Package Name:io.github.jetqin.repository
// * Date:Nov 4, 201611:47:12 AM 
// * Copyright (c) 2016, jetq All Rights Reserved. 
// * 
// */
//package io.github.jetqin.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.stereotype.Repository;
//
//import io.github.jetqin.domain.Result;
//
///**
// * ClassName: ResultRepository
// * 
// * @author jet
// * @version Configuration Framework 1.0
// * @since JDK 1.7
// */
//@Repository
//public interface ResultRepository extends JpaRepository<Result, Integer>
//{
//  // @StoredProcedureParameter(name="LOAD_COUNT",mode=ParameterMode.OUT,type=Integer.class),
//  // @StoredProcedureParameter(name="NEW_COUNT",mode=ParameterMode.OUT,type=Integer.class),
//  // @StoredProcedureParameter(name="FAILED_COUNT",mode=ParameterMode.OUT,type=Integer.class),
//  // @StoredProcedureParameter(name="MESSAGE",mode=ParameterMode.OUT,type=String.class)
//  //
//  // @Procedure(name="findLoadResult")
//  // Presult findLoadResult(@Param("LOAD_COUNT") Integer loadCount,
//  // @Param("NEW_COUNT") Integer newCount,
//  // @Param("FAILED_COUNT") Integer failedCount,
//  // @Param("MESSAGE") String message
//  // );
//
//  @Procedure(procedureName = "LOADOPERATEDMONTHLYPROD")
//  Result findLoadResult ( );
//
//}
