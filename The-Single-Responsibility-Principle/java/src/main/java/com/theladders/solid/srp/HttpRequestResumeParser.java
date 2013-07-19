package com.theladders.solid.srp;

import com.theladders.solid.srp.http.HttpRequest;

public class HttpRequestResumeParser
{

  public HttpRequestResumeParser(HttpRequest request)
  {
  }

  public ResumeRequest parse() {
    return new ResumeRequest(true, true);
  }

}
