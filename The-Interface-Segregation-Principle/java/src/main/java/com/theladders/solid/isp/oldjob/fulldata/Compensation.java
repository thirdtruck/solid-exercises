package com.theladders.solid.isp.oldjob.fulldata;

public class Compensation {
  private final String description;
  private final String bonus;
  private final String salary;
  private final String other;
  
  public Compensation(String description, String bonus, String salary, String other)
  {
    this.description = description;
    this.bonus = bonus;
    this.salary = salary;
    this.other = other;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getBonus()
  {
    return bonus;
  }
  
  public String getSalary()
  {
    return salary;
  }
  
  public String getOther()
  {
    return other;
  }
}
