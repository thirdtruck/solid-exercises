package com.theladders.solid.srp;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.*;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.http.HttpSession;
import com.theladders.solid.srp.jobseeker.Jobseeker;

public class TestHttpRequestResumeParser
{
  private static final int APPROVED_JOBSEEKER = 1010;

  private Jobseeker jobseeker;
  private HttpSession session;
  
  @Test
  public void asksForExistingResume()
  {
    ResumeRequest resumeRequest = new ResumeRequest(true, false);
    assertTrue(resumeRequest.isExisting());
  }
  
  @Test
  public void asksForNonExistingResume()
  {
    ResumeRequest resumeRequest = new ResumeRequest(false, false);
    assertFalse(resumeRequest.isExisting());
  }
  
  @Test
  public void asksToMakeResumeActive()
  {
    ResumeRequest resumeRequest = new ResumeRequest(false, true);
    assertTrue(resumeRequest.makeActive());
  }
  
  @Test
  public void asksToNotMakeResumeActive()
  {
    ResumeRequest resumeRequest = new ResumeRequest(false, false);
    assertFalse(resumeRequest.makeActive());
  }
  
  @Test
  public void requestingExistingResume()
  {
    Map<String, String> parameters = new HashMap<>();
    parameters.put("jobId","5");
    parameters.put("whichResume", "existing");
    
    HttpRequest httpRequest = new HttpRequest(session, parameters);
    
    HttpRequestResumeParser parser = new HttpRequestResumeParser(httpRequest);
    ResumeRequest resumeRequest = parser.parse(); 
    assertTrue(resumeRequest.isExisting());
  }
  
  @Test
  public void requestingNonExistingResumeByDefault()
  {
    Map<String, String> parameters = new HashMap<>();
    parameters.put("jobId","5");
    
    HttpRequest httpRequest = new HttpRequest(session, parameters);
    
    HttpRequestResumeParser parser = new HttpRequestResumeParser(httpRequest);
    ResumeRequest resumeRequest = parser.parse(); 
    assertFalse(resumeRequest.isExisting());
  }
  
  @Test
  public void requestingResumeBeMadeActive()
  {
    Map<String, String> parameters = new HashMap<>();
    parameters.put("jobId","5");
    parameters.put("makeResumeActive", "yes");
    
    HttpRequest httpRequest = new HttpRequest(session, parameters);
    
    HttpRequestResumeParser parser = new HttpRequestResumeParser(httpRequest);
    ResumeRequest resumeRequest = parser.parse(); 
    assertTrue(resumeRequest.makeActive());
  }

  @Before
  public void setup()
  {
    jobseeker = new Jobseeker(APPROVED_JOBSEEKER, true);
    session = new HttpSession(jobseeker);
  }
}
