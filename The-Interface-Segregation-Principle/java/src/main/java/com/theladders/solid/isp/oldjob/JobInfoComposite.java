package com.theladders.solid.isp.oldjob;

import com.theladders.solid.isp.oldjob.fulldata.Company;
import com.theladders.solid.isp.oldjob.fulldata.Compensation;

public class JobInfoComposite extends JobImpl
{
  private final Company company;
  private final Compensation compensation;
  
  public JobInfoComposite(Company company, Compensation compensation)
  {
    this.company = company;
    this.compensation = compensation;
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
  public String getCompensation()
  {
    return this.compensation.getDescription();
  }
  
  @Override
  public String getCompensationBonus()
  {
    return this.compensation.getBonus();
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
