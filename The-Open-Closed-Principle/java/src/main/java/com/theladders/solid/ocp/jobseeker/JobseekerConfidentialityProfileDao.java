package com.theladders.solid.ocp.jobseeker;

import java.util.*;


public class JobseekerConfidentialityProfileDao
{
  private Map<Integer, JobseekerConfidentialityProfile> profiles;
  
  public JobseekerConfidentialityProfileDao()
  {
    profiles = new HashMap<Integer, JobseekerConfidentialityProfile>();
  }
  
  @SuppressWarnings("unused")
  public JobseekerConfidentialityProfile fetchJobSeekerConfidentialityProfile(int id)
  {
    JobseekerConfidentialityProfile profile = profiles.get(new Integer(id));
    if(profile != null)
    {
       return profile;
    }
    
    profile = new JobseekerConfidentialityProfile();
    profiles.put(new Integer(id), profile);
    return profile;
  }
}
