package com.theladders.solid.lsp;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

public class TestApp
{
  private static final String hostName = "www.theladders.com/";

  @Before
  public void setUp() throws Exception
  {
    ByteArrayInputStream in = new ByteArrayInputStream("true".getBytes());
    System.setIn(in);
  }

  @Test
  public void test()
  {
    EnvSetupFilter filter = new EnvSetupFilter(hostName);
    Environment env = filter.getEnvironment(true, true);
  }

}
