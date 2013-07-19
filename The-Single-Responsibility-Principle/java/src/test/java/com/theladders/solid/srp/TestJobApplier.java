package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.*;

import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.JobApplicationResult;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.ActiveResumeRepository;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;
import com.theladders.solid.srp.resume.ResumeRepository;

public class TestJobApplier
{
  private static final int JOBSEEKER_WITH_RESUME = 777;
  
  private ResumeController resumeController;
  
  @Test
  public void canApply()
  {
    String fileName = "Blammo";
    Jobseeker jobseeker = new Jobseeker(JOBSEEKER_WITH_RESUME, true);
    Job job = new Job(15);
    ResumeRequest resumeRequest = new ResumeRequest(false, false);
    
    JobApplier applier = new JobApplier(resumeController,
                                        resumeRequest,
                                        jobseeker,
                                        job,
                                        fileName);
    applier.apply();
  }
  
  @Test
  public void canApplySuccessfully()
  {
    String fileName = "Blammo";
    Jobseeker jobseeker = new Jobseeker(JOBSEEKER_WITH_RESUME, true);
    Job job = new Job(15);
    ResumeRequest resumeRequest = new ResumeRequest(false, false);
    
    JobApplier applier = new JobApplier(resumeController,
                                        resumeRequest,
                                        jobseeker,
                                        job,
                                        fileName);
    
    JobApplicationResult status = applier.apply();
    assertFalse(status.failure());
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
  }
  
}
