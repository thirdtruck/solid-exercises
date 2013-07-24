package com.theladders.solid.isp.oldjob;

import com.theladders.solid.isp.oldjob.fulldata.*;

public class JobInfoComposite extends JobImpl implements BasicJobInfo, CompanyInfo, CompensationInfo
{
  private final Company company;
  private final Compensation compensation;
  private final BasicJob basicJob;
  
  public JobInfoComposite(BasicJob basicJob, Company company, Compensation compensation)
  {
    this.basicJob = basicJob;
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
  public String getCompensationSalary()
  {
    return compensation.getSalary();
  }
  
  @Override
  public String getCompensationOther()
  {
    return compensation.getOther();
  }

  @Override
  public boolean isJobReq() {
    return basicJob.isReq();
  }

  @Override
  public String getDescription() {
    return basicJob.getDescription();
  }
}
