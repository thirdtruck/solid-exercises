package com.theladders.solid.isp.oldjob;

import com.theladders.solid.isp.oldjob.fulldata.Accessibility;
import com.theladders.solid.isp.oldjob.fulldata.BasicJob;
import com.theladders.solid.isp.oldjob.fulldata.Company;
import com.theladders.solid.isp.oldjob.fulldata.Compensation;
import com.theladders.solid.isp.oldjob.fulldata.Location;

public class App
{
  
  private static void runApp()
  {
    Integer companySize = new Integer(50);
    
    Accessibility anAccessibility = new Accessibility(true, true, true);
    
    BasicJob aBasicJob = new BasicJob(false, "A nice place to work!");
    
    Company aCompany = new Company("Example Ltd.", companySize);
    
    Compensation aCompensation = new Compensation("Annual", "$1000", "$100000", "Other");
    
    Location aLocation = new Location("Anywhere, USA");
    
    JobInfoComposite composite = new JobInfoComposite(anAccessibility, aBasicJob, aCompany, aCompensation, aLocation);
    
    // AccessibilityController acessibilityController = new AccessibilityController(accessibilityView, (AccessibilityInfo)composite);
    // LocationController LocationController = new LocationController(locationSettingView, (LocationInfo)composite);
    
  }

  public static void main(String[] args)
  {

    runApp();

  }

}
