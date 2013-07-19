package com.theladders.solid.srp;

public class ResumeRequest
{

  private boolean existing;
  private boolean makeActive;

  public ResumeRequest(boolean existing, boolean makeActive)
  {
    this.existing = existing;
    this.makeActive = makeActive;
  }
  
  public boolean isExisting()
  {
    return existing;
  }
  
  public boolean makeActive()
  {
    return makeActive;
  }

}
