package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.srp.jobseeker.Jobseeker;

public class TestResumePolicy
{

  private static final int APPROVED_JOBSEEKER    = 1010;
  
  @Before
  public void setup()
  {
  }

  @Test
  public void canInitialize()
  {
    ResumePolicy policy = new ResumePolicy();
  }
  
  @Test
  public void requiresCompletedResume()
  {
    Jobseeker jobseeker = new Jobseeker(APPROVED_JOBSEEKER, true);

    ResumePolicy policy = new ResumePolicy();
    
    assertTrue(policy.requiresCompletedResume(jobseeker));
  }

}
