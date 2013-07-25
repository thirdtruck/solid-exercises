package com.theladders.solid.isp.oldjob;

import java.util.ArrayList;
import java.util.List;

import com.theladders.solid.isp.oldjob.fulldata.*;
import com.theladders.solid.isp.oldjob.stubs.*;

public class App
{
  private Integer companySize;
  private Accessibility anAccessibility;
  private BasicJob aBasicJob;
  private Company aCompany;
  private Compensation aCompensation;
  private List<Discipline> aDisciplineList;
  private Experience anExperience;
  private Location aLocation;
  private JobInfoComposite composite;
  
  public App()
  {
    companySize = new Integer(50);
    
    anAccessibility = new Accessibility(true, true, true);
    
    aBasicJob = new BasicJob(false, "A nice place to work!");
    
    aCompany = new Company("Example Ltd.", companySize);
    
    aCompensation = new Compensation("Annual", "$1000", "$100000", "Other");
    
    aDisciplineList = new ArrayList<Discipline>();
    
    anExperience = new Experience();
    
    aLocation = new Location("Anywhere, USA");
    
    composite = new JobInfoComposite(anAccessibility, aBasicJob, aCompany, aCompensation, aDisciplineList, anExperience, aLocation);
    
    // AccessibilityController acessibilityController = new AccessibilityController(accessibilityView, (AccessibilityInfo)composite);
    // LocationController LocationController = new LocationController(locationSettingView, (LocationInfo)composite);
  }
  
  public static void runApp()
  {
    App anApp = new App();
  }

  public static void main(String[] args)
  {

    runApp();

  }

}
