package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.ProfileStatus;

public class TestProfilePolicy
{

  private static final int APPROVED_JOBSEEKER    = 1010;
  
  @Before
  public void setup()
  {
  }
  
  @Test
  public void requiresCompletedProfile()
  {
    Jobseeker jobseeker = new Jobseeker(APPROVED_JOBSEEKER, true);

    ProfilePolicy policy = new ProfilePolicy();
    
    assertTrue(policy.requiresCompletedProfile(jobseeker));
  }
  
  @Test
  public void isProfileAcceptable_Incomplete()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertTrue(policy.isProfileAcceptable(ProfileStatus.INCOMPLETE));
  }
  
  @Test
  public void isProfileAcceptable_NoProfile()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertTrue(policy.isProfileAcceptable(ProfileStatus.NO_PROFILE));
  }
  
  @Test
  public void isProfileAcceptable_Removed()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertTrue(policy.isProfileAcceptable(ProfileStatus.REMOVED));
  }

}
