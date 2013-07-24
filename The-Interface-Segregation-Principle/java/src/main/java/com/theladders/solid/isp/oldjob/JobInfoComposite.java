package com.theladders.solid.isp.oldjob;

import com.theladders.solid.isp.oldjob.fulldata.Company;

public class JobInfoComposite extends JobImpl
{
  private final Company company;
  
  public JobInfoComposite(Company company)
  {
    this.company = company;
  }
  
  @Override
  public String getCompany()
  {
    return company.getName();
  }
  
  @Override
  public Integer getCompanySize()
  {
    return company.getSize();
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
