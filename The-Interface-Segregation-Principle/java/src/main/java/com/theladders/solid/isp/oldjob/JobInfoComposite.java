package com.theladders.solid.isp.oldjob;

public class JobInfoComposite extends JobImpl
{
  public JobInfoComposite()
  {
  }

  @Override
  public boolean isJobReq() {
    return false;
  }

  @Override
  public String getDescription() {
    return "";
  }
}
