package com.theladders.solid.isp.oldjob;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.isp.oldjob.JobInfoComposite;
import com.theladders.solid.isp.oldjob.fulldata.Company;


public class TestJobInfoComposite
{
  
  private JobInfoComposite composite;
  
  private void givenAJobInfoCompositeInstance()
  {
    Company company = new Company("Example Ltd.", new Integer(50));
    composite = new JobInfoComposite(company);
  }

  private void whenISetTheDefaultValuesOnTheJobInfoComposite()
  {
    composite.setCompensation("$100000/year");
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
    assertEquals(new Integer(50), composite.getCompanySize());
  }

  @Test
  public void thenItShouldHaveTheRightCompensation()
  {
    assertEquals("$100000/year", composite.getCompensation());
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
