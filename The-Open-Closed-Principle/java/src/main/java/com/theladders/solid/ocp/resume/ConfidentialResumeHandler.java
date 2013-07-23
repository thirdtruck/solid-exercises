package com.theladders.solid.ocp.resume;

import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfile;
import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfileDao;
import com.theladders.solid.ocp.user.User;

public class ConfidentialResumeHandler
{
  private final JobseekerProfileManager            jobSeekerProfileManager;
  private final JobseekerConfidentialityProfileDao jobseekerConfidentialityProfileDao;

  public ConfidentialResumeHandler(JobseekerProfileManager jobseekerProfileManager,
                                   JobseekerConfidentialityProfileDao jobseekerConfidentialityProfileDao)
  {
    this.jobSeekerProfileManager = jobseekerProfileManager;
    this.jobseekerConfidentialityProfileDao = jobseekerConfidentialityProfileDao;
  }

  public void makeAllCategoriesNonConfidential(User user)
  {
    JobseekerProfile jsp = jobSeekerProfileManager.getJobseekerProfile(user);
    JobseekerConfidentialityProfile profile = jobseekerConfidentialityProfileDao.fetchJobseekerConfidentialityProfile(jsp.getId());

    boolean isChanged = false;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.Name) || isChanged;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.PhoneNumber) || isChanged;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.EmailAddress) || isChanged;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.MailingAddress) || isChanged;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.ContactInfo) || isChanged;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.CompanyName) || isChanged;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.WorkExperience) || isChanged;

    if (isChanged)
    {
      generatePermanentConfidentialFiles(user, profile);
    }
  }

  public void makeAllContactInfoNonConfidential(User user)
  {
    JobseekerProfile jsp = jobSeekerProfileManager.getJobseekerProfile(user);
    JobseekerConfidentialityProfile profile = jobseekerConfidentialityProfileDao.fetchJobseekerConfidentialityProfile(jsp.getId());
    boolean isChanged = false;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.PhoneNumber) || isChanged;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.EmailAddress) || isChanged;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.MailingAddress) || isChanged;
    isChanged = profile.markCategoryPhrasesAsPublic(ConfidentialPhraseCategories.ContactInfo) || isChanged;

    if (isChanged)
    {
      generatePermanentConfidentialFiles(user, profile);
    }
  }

  @SuppressWarnings("unused")
  private void generatePermanentConfidentialFiles(User user,
                                                  JobseekerConfidentialityProfile profile)
  {
    // stub
  }
}
