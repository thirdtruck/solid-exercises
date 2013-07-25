package com.theladders.solid.isp.oldjob;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.isp.oldjob.JobInfoComposite;
import com.theladders.solid.isp.oldjob.fulldata.*;
import com.theladders.solid.isp.oldjob.stubs.*;


public class TestJobInfoCompositeDefaults
{
  private AccessibilityInfo accessibility;
  
  private JobInfoComposite composite;
  
  private void givenAJobInfoCompositeInstance()
  {
    Accessibility anAccessibility = new Accessibility(false, false, false);
    
    BasicJob aBasicJob = new BasicJob(false, null);
    
    Company aCompany = new Company(null, null);
    
    Compensation aCompensation = new Compensation(null, null, null, null);
    
    List<Discipline> aDisciplineList = new ArrayList<Discipline>();
    
    Location aLocation = new Location(null);
    
    composite = new JobInfoComposite(anAccessibility, aBasicJob, aCompany, aCompensation, aDisciplineList, anExperience, aLocation);
  }

  private void whenISetTheDefaultValuesOnTheJobInfoComposite()
  {
  }
  
  private void whenIDecompositeItIntoItsInterfaces()
  {
    accessibility = (AccessibilityInfo)composite;
  }

  @Before
  public void setUp()
  {
    givenAJobInfoCompositeInstance();
    whenISetTheDefaultValuesOnTheJobInfoComposite();
    whenIDecompositeItIntoItsInterfaces();
  }

  @Test
  public void thenTheAccessibilityShouldHaveTheRightDefaultAnonymity()
  {
    assertFalse(accessibility.isAnonymous());
  }
  
  @Test
  public void thenTheAccessibilityShouldHaveTheRightDefaultConfidentiality()
  {
    assertFalse(accessibility.isConfidential());
  }
  
  @Test
  public void thenTheAccessibilityShouldHaveTheRightDefaultExclusivity()
  {
    assertFalse(accessibility.isExclusive());
  }

}
