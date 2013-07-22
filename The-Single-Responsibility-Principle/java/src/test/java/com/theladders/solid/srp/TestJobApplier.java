package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.*;

import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.JobApplicationRepository;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.ActiveResumeRepository;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;
import com.theladders.solid.srp.resume.ResumeRepository;

public class TestJobApplier
{
  private static final int JOBSEEKER_WITH_RESUME = 777;
  private static final int APPROVED_JOBSEEKER    = 1010;
  
  private ResumeController resumeController;
  private JobApplicationRepository jobApplicationRepository;
  
  @Test
  public void canApply()
  {
    String fileName = "Blammo";
    Jobseeker jobseeker = new Jobseeker(JOBSEEKER_WITH_RESUME, true);
    Job job = new Job(15);
    ResumeRequest resumeRequest = new ResumeRequest(false, false);
    
    JobApplier applier = new JobApplier(resumeController, jobApplicationRepository);
    applier.apply(resumeRequest,
                  jobseeker,
                  job,
                  fileName);
  }
  
  @Test
  public void canApplySuccessfully()
  {
    String fileName = "Blammo";
    Jobseeker jobseeker = new Jobseeker(JOBSEEKER_WITH_RESUME, true);
    Job job = new Job(15);
    ResumeRequest resumeRequest = new ResumeRequest(false, false);
    
    JobApplier applier = new JobApplier(resumeController, jobApplicationRepository);

    JobApplierResult result = applier.apply(resumeRequest,
                                            jobseeker,
                                            job,
                                            fileName);
    assertTrue(result.wasSuccessful());
  }
  
  @Test
  public void canApplyUnsuccessfully()
  {
    String fileName = null;
    Jobseeker jobseeker = new Jobseeker(APPROVED_JOBSEEKER, true);
    Job job = new Job(5);
    ResumeRequest resumeRequest = new ResumeRequest(false, false);
    
    JobApplier applier = new JobApplier(resumeController, jobApplicationRepository);

    JobApplierResult result = applier.apply(resumeRequest,
                                            jobseeker,
                                            job,
                                            fileName);
    assertFalse(result.wasSuccessful());
  }
  
  @Test
  public void cannotApplyToTheSameJobTwice()
  {
    String fileName = "Blammo";
    Jobseeker jobseeker = new Jobseeker(JOBSEEKER_WITH_RESUME, true);
    Job job = new Job(15);
    ResumeRequest resumeRequest = new ResumeRequest(false, false);
    
    JobApplier applier = new JobApplier(resumeController, jobApplicationRepository);

    JobApplierResult result1 = applier.apply(resumeRequest,
                                            jobseeker,
                                            job,
                                            fileName);
    assertTrue(result1.wasSuccessful());

    JobApplierResult result2 = applier.apply(resumeRequest,
                                            jobseeker,
                                            job,
                                            fileName);
    assertFalse(result2.wasSuccessful());
  }
  
  @Before
  public void setup()
  {
    ResumeRepository resumeRepository = new ResumeRepository();
    ActiveResumeRepository activeResumeRepository = new ActiveResumeRepository();

    activeResumeRepository.makeActive(JOBSEEKER_WITH_RESUME, new Resume("Blammo"));
    
    ResumeManager resumeManager = new ResumeManager(resumeRepository);
    MyResumeManager myResumeManager = new MyResumeManager(activeResumeRepository);

    resumeController = new ResumeController(resumeManager, myResumeManager);
    
    jobApplicationRepository = new JobApplicationRepository();
  }
  
}
