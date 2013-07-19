package com.theladders.solid.srp;

import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.JobApplicationRepository;
import com.theladders.solid.srp.job.application.JobApplicationResult;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.job.application.UnprocessedApplication;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.Resume;

public class JobApplier {

  private JobApplicationSystem jobApplicationSystem;
  private ResumeController resumeController;

  public JobApplier(ResumeController resumeController) {
    JobApplicationRepository jobApplicationRepository = new JobApplicationRepository();
    jobApplicationSystem = new JobApplicationSystem(jobApplicationRepository);
    this.resumeController = resumeController;
  }

  public boolean apply(ResumeRequest resumeRequest, Jobseeker jobseeker, Job job,
      String fileName)
  {
    try
    {
      Resume resume = resumeController.saveNewOrRetrieveExistingResume(fileName, jobseeker, resumeRequest);
      UnprocessedApplication application = new UnprocessedApplication(jobseeker, job, resume);
      JobApplicationResult jobApplicationResult = jobApplicationSystem.apply(application);
      return ! jobApplicationResult.failure();
    }
    catch (Exception e)
    {
      return false;
    }
  }

}
