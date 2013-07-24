package com.theladders.solid.isp.oldjob.fulldata;

public class Compensation {
  private final String description;
  private final String bonus;
  
  public Compensation(String description, String bonus)
  {
    this.description = description;
    this.bonus = bonus;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getBonus()
  {
    return bonus;
  }
}
