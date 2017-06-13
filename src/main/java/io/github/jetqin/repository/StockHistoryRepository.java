
/** 
 * Project Name:demo-auth 
 * File Name:CustomerRepository.java
 * Package Name:io.github.jetqin.repository
 * Date:下午9:31:15
 * Copyright (c) 2016,qinjet@gmail.com All Rights Reserved. 
 * 
 */

package io.github.jetqin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.jetqin.domain.StockHistory;
import io.github.jetqin.domain.StockHistoryID;

/**
 * @author jet
 *
 */
@Repository
public interface StockHistoryRepository extends JpaRepository<StockHistory, StockHistoryID>
{

}