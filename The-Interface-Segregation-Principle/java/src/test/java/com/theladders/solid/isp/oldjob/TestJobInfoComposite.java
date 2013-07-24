package com.theladders.solid.isp.oldjob;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.isp.oldjob.JobInfoComposite;
import com.theladders.solid.isp.oldjob.fulldata.Company;
import com.theladders.solid.isp.oldjob.fulldata.Compensation;


public class TestJobInfoComposite
{
  
  private JobInfoComposite composite;
  
  private final Integer companySize = new Integer(50);
  
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

  @Before
  public void setUp()
  {
    givenAJobInfoCompositeInstance();
    whenISetTheDefaultValuesOnTheJobInfoComposite();
  }

  @Test
  public void thenItShouldHaveTheRightCompanyName()
  {
    assertEquals("Example Ltd.", composite.getCompany());
  }

  @Test
  public void thenItShouldHaveTheRightCompanySize()
  {
    assertEquals(companySize, composite.getCompanySize());
  }

  @Test
  public void thenItShouldHaveTheRightCompensation()
  {
    assertEquals("$100000/year", composite.getCompensation());
  }

  @Test
  public void thenItShouldHaveTheRightCompensationBonus()
  {
    assertEquals("$1000", composite.getCompensationBonus());
  }

  @Test
  public void thenItShouldNotBeAJobReq()
  {
    assertFalse(composite.isJobReq());
  }

  @Test
  public void thenItShouldHaveABlankJobDescription()
  {
    assertEquals("", composite.getDescription());
  }

}
