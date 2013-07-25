package com.theladders.solid.isp.oldjob;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.isp.oldjob.JobInfoComposite;
import com.theladders.solid.isp.oldjob.fulldata.*;
import com.theladders.solid.isp.oldjob.stubs.*;


public class TestJobInfoCompositeCustom
{
  
  private JobInfoComposite composite;
  
  private final Integer companySize = new Integer(50);

  private AccessibilityInfo accessibility;
  private BasicJobInfo basicJob;
  private CompanyInfo company;
  private CompensationInfo compensation;
  private DisciplineListInfo disciplines;
  private LocationInfo location;
  
  private Discipline aDiscipline;
  private List<Discipline> aDisciplineList;
  private Experience anExperience;
  
  private void givenAJobInfoCompositeInstance()
  {
    Accessibility anAccessibility = new Accessibility(true, true, true);
    
    BasicJob aBasicJob = new BasicJob(false, "A nice place to work!");
    
    Company aCompany = new Company("Example Ltd.", companySize);
    
    Compensation aCompensation = new Compensation("Annual", "$1000", "$100000", "Other");
    
    aDiscipline = new Discipline();
    aDisciplineList = new ArrayList<Discipline>();
    aDisciplineList.add(aDiscipline);
    
    anExperience = new Experience();
    
    Location aLocation = new Location("Anywhere, USA");
    
    composite = new JobInfoComposite(anAccessibility, aBasicJob, aCompany, aCompensation, aDisciplineList, aLocation);
  }

  private void whenISetTheDefaultValuesOnTheJobInfoComposite()
  {
    composite.setExperience(anExperience);
  }
  
  private void whenIDecompositeItIntoItsInterfaces()
  {
    accessibility = (AccessibilityInfo)composite;
    basicJob = (BasicJobInfo)composite;
    company = (CompanyInfo)composite;
    compensation = (CompensationInfo)composite;
    disciplines = (DisciplineListInfo)composite;
    location = (LocationInfo)composite;
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
  public void thenTheCompensationShouldHaveTheRightCompensation()
  {
    assertEquals("Annual", compensation.getCompensation());
  }

  @Test
  public void thenTheCompensationShouldHaveTheRightCompensationBonus()
  {
    assertEquals("$1000", compensation.getCompensationBonus());
  }

  @Test
  public void thenTheCompensationShouldHaveTheRightCompensationSalary()
  {
    assertEquals("$100000", compensation.getCompensationSalary());
  }

  @Test
  public void thenTheCompensationShouldHaveTheRightCompensationOther()
  {
    assertEquals("Other", compensation.getCompensationOther());
  }

  @Test
  public void thenTheBasicJobShouldHaveTheRightReqStatus()
  {
    assertFalse(basicJob.isJobReq());
  }

  @Test
  public void thenTheBasicJobSHouldHaveTheRightDescription()
  {
    assertEquals("A nice place to work!", basicJob.getDescription());
  }

  @Test
  public void thenTheLocationShouldHaveTheRightLocation()
  {
    assertEquals("Anywhere, USA", location.getLocation());
  }

  @Test
  public void thenTheAccessibilityShouldHaveTheRightAnonymity()
  {
    assertTrue(accessibility.isAnonymous());
  }
  
  @Test
  public void thenTheAccessibilityShouldHaveTheRightConfidentiality()
  {
    assertTrue(accessibility.isConfidential());
  }
  
  @Test
  public void thenTheAccessibilityShouldHaveTheRightExclusivity()
  {
    assertTrue(accessibility.isExclusive());
  }
  
  @Test
  public void thenTheDisciplinesShouldHaveTheRightDisciplineList()
  {
    assertTrue(aDisciplineList.equals(disciplines.getDisciplines()));
  }
  
  @Test
  public void thenTheCompositeShouldHaveTheRightExperience()
  {
    assertTrue(composite.getExperience().equals(anExperience));
  }

}
