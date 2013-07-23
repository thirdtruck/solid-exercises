package com.theladders.solid.lsp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEnvSetupFilter {
  
  private static final String hostName = "www.theladders.com/";
  private EnvSetupFilter filter;

  @Before
  public void setUp()
  {
    filter = new EnvSetupFilter(hostName);
  }

  @Test
  public void testIsSecureAndIsLoggedInUser()
  {
    boolean isSecure = true;
    boolean loggedInUser = true;

    Environment env = filter.getEnvironment(isSecure, loggedInUser);
    
    assertEquals("true", env.get("isSSL"));
    assertEquals("https://www.theladders.com/member/", env.get("secureHome"));
    // TODO: determine why this shows up twice and with different values
    //assertEquals("?", env.get("home"));
    assertEquals("https://www.theladders.com/", env.get("secureGuestSiteHome"));
    assertEquals("https://www.theladders.com/", env.get("secureFalconSiteHome"));
    assertEquals("https://www.theladders.com/member/", env.get("secureMemberSiteHome"));
    // TODO: determine why this shows up twice and with different values
    //assertEquals("?", env.get("secureHome"));
    assertEquals("http://www.theladders.com/member/", env.get("memberSiteHome"));
    assertEquals("http://www.theladders.com/member/", env.get("home"));
    assertEquals("http://www.theladders.com/", env.get("guestSiteHome"));
    assertEquals("http://www.theladders.com/", env.get("falconSiteHome"));
  }

  @Test
  public void testIsSecureAndIsNotLoggedInUser()
  {
    boolean isSecure = true;
    boolean loggedInUser = false;

    Environment env = filter.getEnvironment(isSecure, loggedInUser);
    
    assertEquals("true", env.get("isSSL"));
    assertEquals("https://www.theladders.com/", env.get("secureHome"));
    // TODO: determine why this shows up twice and with different values
    //assertEquals("?", env.get("home"));
    assertEquals("https://www.theladders.com/", env.get("secureGuestSiteHome"));
    assertEquals("https://www.theladders.com/", env.get("secureFalconSiteHome"));
    assertEquals("https://www.theladders.com/member/", env.get("secureMemberSiteHome"));
    // TODO: determine why this shows up twice and with different values
    //assertEquals("?", env.get("secureHome"));
    assertEquals("http://www.theladders.com/member/", env.get("memberSiteHome"));
    assertEquals("http://www.theladders.com/", env.get("home"));
    assertEquals("http://www.theladders.com/", env.get("guestSiteHome"));
    assertEquals("http://www.theladders.com/", env.get("falconSiteHome"));
  }

  @Test
  public void testIsInsecureAndIsLoggedInUser()
  {
    boolean isSecure = false;
    boolean loggedInUser = true;

    Environment env = filter.getEnvironment(isSecure, loggedInUser);
    
    assertEquals("true", env.get("isSSL"));
    assertEquals("https://www.theladders.com/member/", env.get("secureHome"));
    // TODO: determine why this shows up twice and with different values
    //assertEquals("?", env.get("home"));
    assertEquals("https://www.theladders.com/", env.get("secureGuestSiteHome"));
    assertEquals("https://www.theladders.com/", env.get("secureFalconSiteHome"));
    assertEquals("https://www.theladders.com/member/", env.get("secureMemberSiteHome"));
    // TODO: determine why this shows up twice and with different values
    //assertEquals("?", env.get("secureHome"));
    assertEquals("http://www.theladders.com/member/", env.get("memberSiteHome"));
    assertEquals("http://www.theladders.com/member/", env.get("home"));
    assertEquals("http://www.theladders.com/", env.get("guestSiteHome"));
    assertEquals("http://www.theladders.com/", env.get("falconSiteHome"));
  }

  @Test
  public void testIsInsecureAndIsNotLoggedInUser()
  {
    boolean isSecure = false;
    boolean loggedInUser = false;

    Environment env = filter.getEnvironment(isSecure, loggedInUser);
    
    assertEquals("true", env.get("isSSL"));
    assertEquals("https://www.theladders.com/", env.get("secureHome"));
    // TODO: determine why this shows up twice and with different values
    //assertEquals("?", env.get("home"));
    assertEquals("https://www.theladders.com/", env.get("secureGuestSiteHome"));
    assertEquals("https://www.theladders.com/", env.get("secureFalconSiteHome"));
    assertEquals("https://www.theladders.com/member/", env.get("secureMemberSiteHome"));
    // TODO: determine why this shows up twice and with different values
    //assertEquals("?", env.get("secureHome"));
    assertEquals("http://www.theladders.com/member/", env.get("memberSiteHome"));
    assertEquals("http://www.theladders.com/", env.get("home"));
    assertEquals("http://www.theladders.com/", env.get("guestSiteHome"));
    assertEquals("http://www.theladders.com/", env.get("falconSiteHome"));
  }
}
