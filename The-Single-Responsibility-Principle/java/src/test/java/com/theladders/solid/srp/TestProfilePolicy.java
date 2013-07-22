package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.Test;

import com.theladders.solid.srp.jobseeker.JobseekerProfile;
import com.theladders.solid.srp.jobseeker.ProfileStatus;

public class TestProfilePolicy
{

  private static final int APPROVED_JOBSEEKER    = 1010;
  
  @Test
  public void isProfileAcceptable_Approved()
  {
    ProfilePolicy policy = new ProfilePolicy();
    
    JobseekerProfile profile = new JobseekerProfile(APPROVED_JOBSEEKER, ProfileStatus.APPROVED);
        
    assertTrue(policy.isProfileAcceptable(profile));
  }
  
  @Test
  public void isProfileAcceptable_Incomplete()
  {
    ProfilePolicy policy = new ProfilePolicy();
    
    JobseekerProfile profile = new JobseekerProfile(APPROVED_JOBSEEKER, ProfileStatus.INCOMPLETE);
        
    assertFalse(policy.isProfileAcceptable(profile));
  }
  
  @Test
  public void isProfileAcceptable_NoProfile()
  {
    ProfilePolicy policy = new ProfilePolicy();
    
    JobseekerProfile profile = new JobseekerProfile(APPROVED_JOBSEEKER, ProfileStatus.NO_PROFILE);
        
    assertFalse(policy.isProfileAcceptable(profile));
  }
  
  @Test
  public void isProfileAcceptable_Removed()
  {
    ProfilePolicy policy = new ProfilePolicy();
    
    JobseekerProfile profile = new JobseekerProfile(APPROVED_JOBSEEKER, ProfileStatus.REMOVED);
        
    assertFalse(policy.isProfileAcceptable(profile));
  }
  
  @Test
  public void isProfileUnacceptable_Approved()
  {
    ProfilePolicy policy = new ProfilePolicy();
    
    JobseekerProfile profile = new JobseekerProfile(APPROVED_JOBSEEKER, ProfileStatus.APPROVED);
        
    assertFalse(policy.isProfileUnacceptable(profile));
  }
  
  @Test
  public void isProfileUnacceptable_Incomplete()
  {
    ProfilePolicy policy = new ProfilePolicy();
    
    JobseekerProfile profile = new JobseekerProfile(APPROVED_JOBSEEKER, ProfileStatus.INCOMPLETE);
        
    assertTrue(policy.isProfileUnacceptable(profile));
  }
  
  @Test
  public void isProfileUnacceptable_NoProfile()
  {
    ProfilePolicy policy = new ProfilePolicy();
    
    JobseekerProfile profile = new JobseekerProfile(APPROVED_JOBSEEKER, ProfileStatus.NO_PROFILE);
        
    assertTrue(policy.isProfileUnacceptable(profile));
  }
  
  @Test
  public void isProfileUnacceptable_Removed()
  {
    ProfilePolicy policy = new ProfilePolicy();
    
    JobseekerProfile profile = new JobseekerProfile(APPROVED_JOBSEEKER, ProfileStatus.REMOVED);
        
    assertTrue(policy.isProfileUnacceptable(profile));
  }

}
