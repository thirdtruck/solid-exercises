package com.theladders.solid.srp;

import com.theladders.solid.srp.jobseeker.Jobseeker;

public class ResumePolicy
{

  public boolean requiresCompletedResume(Jobseeker jobseeker) {
    return true;
  }

}
