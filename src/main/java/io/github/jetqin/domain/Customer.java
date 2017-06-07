
/** 
 * Project Name:demo-auth 
 * File Name:Customer.java
 * Package Name:io.github.jetqin.domain
 * Date:下午9:26:40
 * Copyright (c) 2016,qinjet@gmail.com All Rights Reserved. 
 * 
 */

package io.github.jetqin.domain;

/**
 * @author jet
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "CUSTOMER")
public class Customer
{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long   id;
  private String firstName;
  private String lastName;

  protected Customer ()
  {
  }

  public Customer (String firstName, String lastName)
  {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString ( )
  {
    return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
  }

}