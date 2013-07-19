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
  private HttpRequest request;

  @Test
  public void canCreateHttpRequestResumeParser()
  {
    HttpRequestResumeParser parser = new HttpRequestResumeParser(request);
  }

  @Before
  public void setup()
  {
    jobseeker = new Jobseeker(APPROVED_JOBSEEKER, true);
    session = new HttpSession(jobseeker);

    Map<String, String> parameters = new HashMap<>();
    parameters.put("jobId","5");

    request = new HttpRequest(session, parameters);
  }
}
