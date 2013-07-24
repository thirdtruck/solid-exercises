package com.theladders.solid.isp.oldjob;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.isp.oldjob.JobInfoComposite;
import com.theladders.solid.isp.oldjob.fulldata.*;


public class TestJobInfoCompositeDefaults
{
  
  private JobInfoComposite composite;
  
  private void givenAJobInfoCompositeInstance()
  {
    BasicJob aBasicJob = new BasicJob(false, null);
    
    Company aCompany = new Company(null, null);
    
    Compensation aCompensation = new Compensation(null, null, null, null);
    
    Location aLocation = new Location(null);
    
    composite = new JobInfoComposite(aBasicJob, aCompany, aCompensation, aLocation);
  }

  private void whenISetTheDefaultValuesOnTheJobInfoComposite()
  {
  }
  
  private void whenIDecompositeItIntoItsInterfaces() {
  }

  @Before
  public void setUp()
  {
    givenAJobInfoCompositeInstance();
    whenISetTheDefaultValuesOnTheJobInfoComposite();
    whenIDecompositeItIntoItsInterfaces();
  }

  @Test
  public void thenTheCompositeShouldHaveTheRightDefaultAnonymity()
  {
    assertFalse(composite.isAnonymous());
  }
  
  @Test
  public void thenTheCompositeShouldHaveTheRightDefaultConfidentiality()
  {
    assertFalse(composite.isConfidential());
  }
  
  @Test
  public void thenTheCompositeShouldHaveTheRightDefaultExclusivity()
  {
    assertFalse(composite.isExclusive());
  }

}
