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
  private Jobseeker jobseeker;
  private Job job;
  private String fileName;
  private ResumeRequest resumeRequest;

  public JobApplier(ResumeController resumeController, ResumeRequest resumeRequest, Jobseeker jobseeker, Job job,
      String fileName) {
    JobApplicationRepository jobApplicationRepository = new JobApplicationRepository();
    jobApplicationSystem = new JobApplicationSystem(jobApplicationRepository);
    this.resumeController = resumeController;
    this.resumeRequest = resumeRequest;
    this.jobseeker = jobseeker;
    this.job = job;
    this.fileName = fileName;
  }

  public boolean apply()
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
