package com.theladders.solid.isp.oldjob;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.isp.oldjob.JobInfoComposite;
import com.theladders.solid.isp.oldjob.fulldata.*;


public class TestJobInfoComposite
{
  
  private JobInfoComposite composite;
  
  private final Integer companySize = new Integer(50);
  
  private CompanyInfo company;
  private CompensationInfo compensation;
  private BasicJob basicJob;
  
  private void givenAJobInfoCompositeInstance()
  {
    Company company = new Company("Example Ltd.", companySize);
    
    Compensation compensation = new Compensation("$100000/year", "$1000");
    
    composite = new JobInfoComposite(company, compensation);
  }

  private void whenISetTheDefaultValuesOnTheJobInfoComposite()
  {
//    composite.setCompensation("$100000/year");
  }
  
  private void whenIDecompositeItIntoItsInterfaces() {
    company = (CompanyInfo)composite;
    compensation = (CompensationInfo)composite;
    basicJob = (BasicJob)composite;
  }

  @Before
  public void setUp()
  {
    givenAJobInfoCompositeInstance();
    whenISetTheDefaultValuesOnTheJobInfoComposite();
    whenIDecompositeItIntoItsInterfaces();
  }

  @Test
  public void thenTheCompanyShouldHaveTheRightCompanyName()
  {
    assertEquals("Example Ltd.", company.getCompany());
  }

  @Test
  public void thenTheCompanyShouldHaveTheRightCompanySize()
  {
    assertEquals(companySize, company.getCompanySize());
  }

  @Test
  public void thenItShouldHaveTheRightCompensation()
  {
    assertEquals("$100000/year", compensation.getCompensation());
  }

  @Test
  public void thenItShouldHaveTheRightCompensationBonus()
  {
    assertEquals("$1000", compensation.getCompensationBonus());
  }

  @Test
  public void thenItShouldNotBeAJobReq()
  {
    assertFalse(basicJob.isJobReq());
  }

  @Test
  public void thenItShouldHaveABlankJobDescription()
  {
    assertEquals("", basicJob.getDescription());
  }

}
