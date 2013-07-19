package com.theladders.solid.srp;

public class JobApplierResult
{
  private final boolean success;
  private final String message;
  
  public JobApplierResult(boolean success, String message)
  {
    this.success = success;
    this.message = message;
  }
  
  public boolean wasSuccessful()
  {
    return success;
  }
  
  public String getMessage()
  {
    return message;
  }
}