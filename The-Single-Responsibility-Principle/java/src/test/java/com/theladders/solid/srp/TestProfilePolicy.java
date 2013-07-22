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
  public void isProfileAcceptable_Approved()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertTrue(policy.isProfileAcceptable(ProfileStatus.APPROVED));
  }
  
  @Test
  public void isProfileAcceptable_Incomplete()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertFalse(policy.isProfileAcceptable(ProfileStatus.INCOMPLETE));
  }
  
  @Test
  public void isProfileAcceptable_NoProfile()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertFalse(policy.isProfileAcceptable(ProfileStatus.NO_PROFILE));
  }
  
  @Test
  public void isProfileAcceptable_Removed()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertFalse(policy.isProfileAcceptable(ProfileStatus.REMOVED));
  }
  
  @Test
  public void isProfileUnacceptable_Approved()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertFalse(policy.isProfileUnacceptable(ProfileStatus.APPROVED));
  }
  
  @Test
  public void isProfileUnacceptable_Incomplete()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertTrue(policy.isProfileUnacceptable(ProfileStatus.INCOMPLETE));
  }
  
  @Test
  public void isProfileUnacceptable_NoProfile()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertTrue(policy.isProfileUnacceptable(ProfileStatus.NO_PROFILE));
  }
  
  @Test
  public void isProfileUnacceptable_Removed()
  {
    ProfilePolicy policy = new ProfilePolicy();
        
    assertTrue(policy.isProfileUnacceptable(ProfileStatus.REMOVED));
  }

}
