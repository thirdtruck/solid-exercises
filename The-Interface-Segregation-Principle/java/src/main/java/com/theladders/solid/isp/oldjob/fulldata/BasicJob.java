package com.theladders.solid.isp.oldjob.fulldata;

public class BasicJob {
  private final boolean isReq;
  private final String description;
  
  public BasicJob(boolean isReq, String description)
  {
    this.isReq = isReq;
    this.description = description;
  }
  
  public boolean isReq()
  {
    return isReq;
  }
  
  public String getDescription()
  {
    return description;
  }
}
