package com.theladders.solid.lsp;

import java.util.HashMap;
import java.util.Map;

/**
 * This filter puts an Environment object in the request and session. The environment is determined
 * by the host part of the request URL: if the host corresponds to a specific ladder, that ladder's
 * environment is selected; if the host is anything else -- including 'www', a default 'TheLadder'
 * environment is used. This filter also populates the AdminUpdater thread-local var.
 *
 * @author Zhi-Da Zhong &lt;zz@theladders.com&gt;
 */

public class EnvSetupFilter
{
  public static final String               SECURE_HOST = "secure";

  // insecure, auto -> secure
  private static final SecurePropMap securePropMap = new SecurePropMap();
  // auto -> insecure
  private static final InsecurePropMap insecurePropMap = new InsecurePropMap();
  // secure -> insecure
  private static final Map<String, String> noSSLPropMap = new HashMap<>();

  private static final String              AUTO_HOME   = "autoProtoHome";
  private static final String              MEMBER_HOME = "memberHome";
  private static final String              GUEST_HOME  = "guestHome";

  private final String hostName;

  public EnvSetupFilter(String hostName)
  {
    this.hostName = hostName;
  }

  public Environment buildEnvironment(boolean isSecure, boolean loggedInUser)
  {
    Environment baseEnv = EnvironmentFactory.getEnvironmentFor(hostName);

    boolean sslIsSupported = Boolean.parseBoolean((String) baseEnv.get("isSSL"));

    Map<String, String> keyMap = buildSecurityConfigurationKeyMap(isSecure,
        sslIsSupported);

    Environment securityConfiguredEnvironment = mergeInSecurityConfigurations(baseEnv, keyMap);
    
    addHomeSiteURLs(securityConfiguredEnvironment);

    if (loggedInUser)
    {
      securityConfiguredEnvironment.put("home", securityConfiguredEnvironment.get("home") + SiteConfiguration.MEMBER_PATH_PREFIX);
      securityConfiguredEnvironment.put("secureHome", securityConfiguredEnvironment.get("secureHome") + SiteConfiguration.MEMBER_PATH_PREFIX);
    }

    return securityConfiguredEnvironment;
  }

  private void addHomeSiteURLs(Environment environment) {
    environment.put(SiteConfiguration.GUEST_SITE_HOME, environment.get("home"));
    environment.put(SiteConfiguration.SECURE_GUEST_SITE_HOME, environment.get("secureHome"));
    environment.put(SiteConfiguration.FALCON_SITE_HOME, environment.get("home"));
    environment.put(SiteConfiguration.SECURE_FALCON_SITE_HOME, environment.get("secureHome"));
    environment.put(SiteConfiguration.MEMBER_SITE_HOME, environment.get("home") + SiteConfiguration.MEMBER_PATH_PREFIX);
    environment.put(SiteConfiguration.SECURE_MEMBER_SITE_HOME, environment.get("secureHome") + SiteConfiguration.MEMBER_PATH_PREFIX);
  }

  private Map<String, String> buildSecurityConfigurationKeyMap(
      boolean isSecure, boolean sslIsSupported) {
    Map<String, String> keyMap;
    if (!sslIsSupported)
    {
      keyMap = new HashMap<>(noSSLPropMap);
    }
    else if (isSecure)
    {
      keyMap = new HashMap<>(securePropMap);
    }
    else
    {
      keyMap = new HashMap<>(insecurePropMap);
    }
    return keyMap;
  }

  private Environment mergeInSecurityConfigurations(Environment baseEnv,
      Map<String, String> keyMap) {
    Environment securityConfiguredEnvironment = new Environment();
    securityConfiguredEnvironment.putAll(baseEnv);
    securityConfiguredEnvironment.putAll(keyMap);
    return securityConfiguredEnvironment;
  }
}
