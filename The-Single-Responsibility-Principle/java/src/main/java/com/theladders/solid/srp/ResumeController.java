package com.theladders.solid.srp;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;

public class ResumeController {

  private final ResumeManager resumeManager;
  private final MyResumeManager myResumeManager;
  
  public ResumeController(ResumeManager resumeManager, MyResumeManager myResumeManager) {
    this.resumeManager = resumeManager;
    this.myResumeManager = myResumeManager;
  }

  public Resume saveNewOrRetrieveExistingResume(String newResumeFileName,
      Jobseeker jobseeker,
      HttpRequest request)
  {
    Resume resume;

    if (!"existing".equals(request.getParameter("whichResume")))
    {
      resume = resumeManager.saveResume(jobseeker, newResumeFileName);

      if (resume != null && "yes".equals(request.getParameter("makeResumeActive")))
      {
        myResumeManager.saveAsActive(jobseeker, resume);
      }
    }
    else
    {
      resume = myResumeManager.getActiveResume(jobseeker.getId());
    }

    return resume;
    
  }  
}
