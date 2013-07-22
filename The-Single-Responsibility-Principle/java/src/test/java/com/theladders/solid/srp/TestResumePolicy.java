package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.ProfileStatus;

public class TestResumePolicy
{

  private static final int APPROVED_JOBSEEKER    = 1010;
  
  @Before
  public void setup()
  {
  }
  
  @Test
  public void requiresCompletedResume()
  {
    Jobseeker jobseeker = new Jobseeker(APPROVED_JOBSEEKER, true);

    ResumePolicy policy = new ResumePolicy();
    
    assertTrue(policy.requiresCompletedResume(jobseeker));
  }
  
  @Test
  public void isResumeIncomplete_Incomplete()
  {
    ResumePolicy policy = new ResumePolicy();
        
    assertTrue(policy.isResumeIncomplete(ProfileStatus.INCOMPLETE));
  }

}
