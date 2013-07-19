package com.theladders.solid.srp;

import static org.junit.Assert.*;

import org.junit.*;

public class TestResumeRequest
{
  
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
  
}
