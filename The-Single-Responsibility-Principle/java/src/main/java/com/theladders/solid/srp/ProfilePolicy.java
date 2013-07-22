package com.theladders.solid.srp;

import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.JobseekerProfile;
import com.theladders.solid.srp.jobseeker.ProfileStatus;

public class ProfilePolicy
{

  public boolean requiresCompletedProfile(Jobseeker jobseeker) {
    return true;
  }

  public boolean isProfileAcceptable(JobseekerProfile profile) {
    return profile.getStatus() != ProfileStatus.INCOMPLETE &&
           profile.getStatus() != ProfileStatus.NO_PROFILE &&
           profile.getStatus() != ProfileStatus.REMOVED;
  }
  
  public boolean isProfileUnacceptable(JobseekerProfile profile)
  {
    return ! isProfileAcceptable(profile);
  }

}
