package com.theladders.solid.ocp.resume;

import com.theladders.solid.ocp.user.User;

public class JobseekerProfileManager
{
  public JobseekerProfile getJobseekerProfile(User user)
  {
    return new JobseekerProfile(user.getId());
  }
}
