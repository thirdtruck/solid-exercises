package com.theladders.solid.isp.oldjob;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.isp.oldjob.JobImpl;
import com.theladders.solid.isp.oldjob.JobInfoComposite;


public class TestJobInfoComposite
{
  
  private JobInfoComposite composite;
  
  private void givenAJobInfoCompositeInstance()
  {
    composite = new JobInfoComposite();
  }

  private void whenISetTheDefaultValuesOnTheJobInfoComposite()
  {
    composite.setCompany("Example Ltd.");
    composite.setCompanySize(new Integer(50));
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

}
