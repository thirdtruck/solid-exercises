package com.theladders.solid.isp.oldjob;

import com.theladders.solid.isp.oldjob.fulldata.*;

public class JobInfoComposite extends JobImpl implements BasicJob, CompanyInfo, CompensationInfo
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
    return compensation.getDescription();
  }
  
  @Override
  public String getCompensationBonus()
  {
    return compensation.getBonus();
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
