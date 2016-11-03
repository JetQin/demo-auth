
/** 
 * Project Name:demo-auth 
 * File Name:PageQuery.java
 * Package Name:com.example.domain
 * Date:下午8:41:43
 * Copyright (c) 2016,qinjet@gmail.com All Rights Reserved. 
 * 
 */

package io.github.jetqin.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author jet
 *
 */
public @Data class PageQuery
{

  private int index;

  private int size;

  private Sort sort;

  private enum Direction
  {
    ASC, DESC
  }

  public PageQuery ()
  {
  }

  public PageQuery (int index, int size)
  {
    this.index = index;
    this.size = size;
  }
  
  public PageQuery (int index, int size,String property)
  {
    this.index = index;
    this.size = size;
    this.sort = new Sort(Direction.ASC, property);
  }

  private static class Sort
  {

    private Direction direction;

    private String property;

    public Sort (Direction direction, String property)
    {
      this.direction = direction;
      this.property = property;
    }

    public String toString ()
    {
      return String.format("sort column %s,in direction %s", property, direction.toString());
    }
  }

  public String toString ()
  {
    return String.format("page index %d,page size %d, sort %s", index, size, sort);
  }
}
