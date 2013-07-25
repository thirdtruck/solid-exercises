package com.theladders.solid.isp.oldjob;

import java.util.List;

import com.theladders.solid.isp.oldjob.fulldata.*;
import com.theladders.solid.isp.oldjob.stubs.Discipline;

public class JobInfoComposite extends JobImpl implements AccessibilityInfo, BasicJobInfo, CompanyInfo, CompensationInfo, DisciplineListInfo, LocationInfo
{
  private final Accessibility accessibility;
  private final Company company;
  private final Compensation compensation;
  private final BasicJob basicJob;
  private final List<Discipline> disciplineList;
  private final Location location;
  
  public JobInfoComposite(Accessibility accessibility, BasicJob basicJob, Company company, Compensation compensation, List<Discipline> disciplineList, Location location)
  {
    this.accessibility = accessibility;
    this.basicJob = basicJob;
    this.company = company;
    this.compensation = compensation;
    this.disciplineList = disciplineList;
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
  
  @Override
  public boolean isAnonymous()
  {
    return accessibility.isAnonymous();
  }
  
  @Override
  public boolean isConfidential()
  {
    return accessibility.isConfidential();
  }
  
  @Override
  public boolean isExclusive()
  {
    return accessibility.isExclusive();
  }

  @Override
  public List<Discipline> getDisciplines() {
    return disciplineList;
  }
  
/*

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
