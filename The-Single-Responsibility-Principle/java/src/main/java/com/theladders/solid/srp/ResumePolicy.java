package com.theladders.solid.srp;

import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.ProfileStatus;

public class ResumePolicy
{

  public boolean requiresCompletedResume(Jobseeker jobseeker) {
    return true;
  }

  public boolean isResumeIncomplete(ProfileStatus incomplete) {
    return true;
  }

}
