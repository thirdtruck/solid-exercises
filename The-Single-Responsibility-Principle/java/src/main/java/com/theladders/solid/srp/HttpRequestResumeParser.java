package com.theladders.solid.srp;

import com.theladders.solid.srp.http.HttpRequest;

public class HttpRequestResumeParser
{

  private HttpRequest httpRequest;

  public HttpRequestResumeParser(HttpRequest httpRequest)
  {
    this.httpRequest = httpRequest;
  }

  public ResumeRequest parse() {
    boolean existing = "existing".equals(httpRequest.getParameter("whichResume"));
    boolean makeActive = "yes".equals(httpRequest.getParameter("makeResumeActive"));
    ResumeRequest resumeRequest = new ResumeRequest(existing, makeActive);
    return resumeRequest;
  }

}
