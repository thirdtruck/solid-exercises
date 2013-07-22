package com.theladders.solid.srp;

import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.ProfileStatus;

public class ProfilePolicy
{

  public boolean requiresCompletedProfile(Jobseeker jobseeker) {
    return true;
  }

  public boolean isProfileAcceptable(ProfileStatus status) {
    return status != ProfileStatus.INCOMPLETE &&
           status != ProfileStatus.NO_PROFILE &&
           status != ProfileStatus.REMOVED;
  }
  
  public boolean isProfileUnacceptable(ProfileStatus status)
  {
    return ! isProfileAcceptable(status);
  }

}
