package com.theladders.solid.isp.oldjob;

import com.theladders.solid.isp.oldjob.fulldata.*;

public class JobInfoComposite extends JobImpl implements BasicJobInfo, CompanyInfo, CompensationInfo, LocationInfo
{
  private final Company company;
  private final Compensation compensation;
  private final BasicJob basicJob;
  private final Location location;
  
  public JobInfoComposite(BasicJob basicJob, Company company, Compensation compensation, Location location)
  {
    this.basicJob = basicJob;
    this.company = company;
    this.compensation = compensation;
    this.location = location;
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
  public boolean isJobReq()
  {
    return basicJob.isReq();
  }

  @Override
  public String getDescription()
  {
    return basicJob.getDescription();
  }
  
  @Override
  public String getLocation()
  {
    return location.getLocation();
  }
  
/*

  @Override
  public List<Discipline> getDisciplines() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Date getEntryDate() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Experience getExperience() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Industry getIndustry() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getOldJobId() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Date getPublicationDate() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Region getRegion() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getReportsTo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getSubscriberId() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String getTitle() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isAnonymous() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isConfidential() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isExclusive() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isReimbursable() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Date getUpdateTime() {
    // TODO Auto-generated method stub
    return null;
  }
*/
}
