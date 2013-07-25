package com.theladders.solid.isp.oldjob;

import java.util.ArrayList;
import java.util.List;

import com.theladders.solid.isp.oldjob.fulldata.*;
import com.theladders.solid.isp.oldjob.stubs.*;

public class App
{
  
  public static void runApp()
  {
    Integer companySize = new Integer(50);
    
    Accessibility anAccessibility = new Accessibility(true, true, true);
    
    BasicJob aBasicJob = new BasicJob(false, "A nice place to work!");
    
    Company aCompany = new Company("Example Ltd.", companySize);
    
    Compensation aCompensation = new Compensation("Annual", "$1000", "$100000", "Other");
    
    List<Discipline> aDisciplineList = new ArrayList<Discipline>();
    
    Experience anExperience = new Experience();
    
    Location aLocation = new Location("Anywhere, USA");
    
    JobInfoComposite composite = new JobInfoComposite(anAccessibility, aBasicJob, aCompany, aCompensation, aDisciplineList, anExperience, aLocation);
    
    // AccessibilityController acessibilityController = new AccessibilityController(accessibilityView, (AccessibilityInfo)composite);
    // LocationController LocationController = new LocationController(locationSettingView, (LocationInfo)composite);
    
  }

  public static void main(String[] args)
  {

    runApp();

  }

}
