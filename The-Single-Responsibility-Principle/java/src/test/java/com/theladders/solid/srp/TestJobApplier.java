package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.*;

import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.jobseeker.Jobseeker;

public class TestJobApplier
{
  private static final int JOBSEEKER_WITH_RESUME = 777;
  
  @Test
  public void canApply()
  {
    String fileName = "Blammo";
    Jobseeker jobseeker = new Jobseeker(JOBSEEKER_WITH_RESUME, true);
    Job job = new Job(15);
    ResumeRequest resumeRequest = new ResumeRequest(false, false);
    
    JobApplier applier = new JobApplier(resumeRequest,
                                        jobseeker,
                                        job,
                                        fileName);
    applier.apply();
  }
  
  @Before
  public void setup()
  {
  }
  
}
