package com.theladders.solid.lsp;

/**
 * Represents the current website configuration
 * <p/>
 * The SiteConfiguration provides the root domain name information about the site as well as a Map
 * of LadderHosts which correspond to subdomains.
 *
 * @author Joshua Levine <jlevine@theladders.com> and (unfortunately)
 * @author Daniel Wislocki <dwislocki@theladders.com>
 */

public class SiteConfiguration
{
  /**
   * @see com.theladders.commons.segments.site.web.filters.site.host.LadderHost instance for the
   *      current request. "ladderHost" is a key to index the Environment instance for this request
   *      JSP: "site.ladderHost"
   */

  public static final String ENVIRONMENT_LADDER_HOST          = "ladderHost";

  /**
   * @see com.theladders.commons.jobsearch.derived.url.JobSearchCriteria instance for the current
   *      request. "jobSearchCriteria" is a key to index the Environment instance for this request
   *      JSP: "site.jobSearchCriteria"
   */

  public static final String ENVIRONMENT_JOB_SEARCH_CRITERIA  = "jobSearchCriteria";

  /**
   * The insecure memberHome address for this request e.g. "http://sales.theladders.com" or
   * "http://marketing.wt1.laddersoffice.com". "insecureMemberHome" is a key to index the
   * Environment instance for this request JSP: use "site.memberHome" JSP explicit:
   * "site.insecureMemberHome"
   */

  public static final String ENVIRONMENT_INSECURE_MEMBER_HOME = "insecureMemberHome";

  /**
   * The secure memberHome address for this request e.g. "https://sales.theladders.com" or
   * "https://marketing.wt1.laddersoffice.com". "secureMemberHome" is a key to index the Environment
   * instance for this request JSP: use "site.memberHome" JSP explicit: "site.secureMemberHome"
   */

  public static final String ENVIRONMENT_SECURE_MEMBER_HOME   = "secureMemberHome";

  /**
   * The insecure guestHome address for this request e.g. "http://sales-jobs.theladders.com" or
   * "http://marketing-jobs.wt1.laddersoffice.com". "insecureGuestHome" is a key to index the
   * Environment instance for this request JSP: use "site.guestHome" JSP explicit:
   * "site.insecureGuestHome"
   */

  public static final String ENVIRONMENT_INSECURE_GUEST_HOME  = "insecureGuestHome";

  /**
   * The secure guestHome address for this request e.g. "http://sales-jobs.theladders.com" or
   * "http://marketing-jobs.wt1.laddersoffice.com". "secureGuestHome" is a key to index the
   * Environment instance for this request JSP: use "site.guestHome" JSP explicit:
   * "site.secureGuestHome"
   */

  public static final String ENVIRONMENT_SECURE_GUEST_HOME    = "secureGuestHome";

  /**
   * When present, this indicates that the user is in the member portion of the site.
   */

  public static final String MEMBER_PATH_PREFIX               = "member/";
  public static final String MEMBER_PATH_PREFIX_NO_SLASH      = "member";

  public static final String GUEST_SITE_HOME                  = "guestSiteHome";
  public static final String SECURE_GUEST_SITE_HOME           = "secureGuestSiteHome";
  public static final String FALCON_SITE_HOME                 = "falconSiteHome";
  public static final String SECURE_FALCON_SITE_HOME          = "secureFalconSiteHome";
  public static final String MEMBER_SITE_HOME                 = "memberSiteHome";
  public static final String SECURE_MEMBER_SITE_HOME          = "secureMemberSiteHome";
}
