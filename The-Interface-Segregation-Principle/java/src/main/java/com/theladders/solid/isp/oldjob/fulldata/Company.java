package com.theladders.solid.isp.oldjob.fulldata;

public class Company {
  private final String name;
  private final Integer size;
  
  public Company(String name, Integer size)
  {
    this.name = name;
    this.size = size;
  }
  
  public String getName()
  {
    return name;
  }
  
  public Integer getSize()
  {
    return size;
  }
}
