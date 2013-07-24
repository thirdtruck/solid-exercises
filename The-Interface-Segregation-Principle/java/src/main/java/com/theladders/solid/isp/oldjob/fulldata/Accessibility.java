package com.theladders.solid.isp.oldjob.fulldata;

public class Accessibility {
  private final boolean anonymous;
  private final boolean confidential;
  private final boolean exclusive;
  
  public Accessibility(boolean anonymous, boolean confidential, boolean exclusive)
  {
    this.anonymous = anonymous;
    this.confidential = confidential;
    this.exclusive = exclusive;
  }
  
  public boolean isAnonymous()
  {
    return anonymous;
  }
  
  public boolean isConfidential()
  {
    return confidential;
  }
  
  public boolean isExclusive()
  {
    return exclusive;
  }
}
