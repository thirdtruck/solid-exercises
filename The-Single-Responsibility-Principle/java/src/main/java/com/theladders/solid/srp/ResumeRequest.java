package com.theladders.solid.srp;

public class ResumeRequest
{

  private boolean existing;

  public ResumeRequest(boolean existing, boolean makeActive)
  {
    this.existing = existing;
  }
  
  public boolean isExisting()
  {
    return existing;
  }

}
