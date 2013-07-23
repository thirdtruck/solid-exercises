import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfileDao;
import com.theladders.solid.ocp.resume.ConfidentialResumeHandler;
import com.theladders.solid.ocp.resume.JobseekerProfileManager;

import junit.framework.TestCase;


public class TestConfidentialResumeHandler extends TestCase
{

  private JobseekerProfileManager jobseekerProfileManager;
  private JobseekerConfidentialityProfileDao jobseekerConfidentialityProfileDao;
  
  private ConfidentialResumeHandler handler;
  
  protected void setUp()
  {
    jobseekerProfileManager = new JobseekerProfileManager();
    jobseekerConfidentialityProfileDao = new JobseekerConfidentialityProfileDao();
    
    handler = new ConfidentialResumeHandler(jobseekerProfileManager, jobseekerConfidentialityProfileDao);
  }
}
