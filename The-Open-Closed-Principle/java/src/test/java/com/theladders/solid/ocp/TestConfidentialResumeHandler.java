package com.theladders.solid.ocp;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfile;
import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfileDao;
import com.theladders.solid.ocp.resume.CategoryType;
import com.theladders.solid.ocp.resume.ConfidentialPhrase;
import com.theladders.solid.ocp.resume.ConfidentialPhraseCategories;
import com.theladders.solid.ocp.resume.ConfidentialResumeHandler;
import com.theladders.solid.ocp.resume.JobseekerProfileManager;
import com.theladders.solid.ocp.user.User;


public class TestConfidentialResumeHandler
{

  private JobseekerProfileManager            profileManager;
  private JobseekerConfidentialityProfileDao dao;
  private JobseekerConfidentialityProfile    profile;
  
  private ConfidentialResumeHandler          handler;
  
  private final int                          USER_ID = 1;                  
  private User                               user;
  
  
  @Before
  public void setUp()
  {
    profileManager = new JobseekerProfileManager();
    dao = new JobseekerConfidentialityProfileDao();
    profile = dao.fetchJobseekerConfidentialityProfile(USER_ID);
    
    profile.addConfidentialPhraseCategory(ConfidentialPhraseCategories.Name);
    profile.addConfidentialPhraseCategory(ConfidentialPhraseCategories.PhoneNumber);
    profile.addConfidentialPhraseCategory(ConfidentialPhraseCategories.EmailAddress);
    profile.addConfidentialPhraseCategory(ConfidentialPhraseCategories.MailingAddress);
    profile.addConfidentialPhraseCategory(ConfidentialPhraseCategories.ContactInfo);
    profile.addConfidentialPhraseCategory(ConfidentialPhraseCategories.CompanyName);
    profile.addConfidentialPhraseCategory(ConfidentialPhraseCategories.WorkExperience);
    
    user = new User(USER_ID);
    
    handler = new ConfidentialResumeHandler(profileManager, dao);
    
    
  }

  @Test
  public void testMakesAllCategoriesPublic()
  {
    handler.makeAllCategoriesNonConfidential(user);
    
    JobseekerConfidentialityProfile profile = dao.fetchJobseekerConfidentialityProfile(USER_ID);
    
    List<ConfidentialPhrase> phrases;
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.Name);
    
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.PhoneNumber);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.EmailAddress);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.MailingAddress);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.ContactInfo);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.CompanyName);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.WorkExperience);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
  }

  @Test
  public void testMakesContactCategoriesPublic()
  {
    handler.makeAllContactInfoNonConfidential(user);
    
    JobseekerConfidentialityProfile profile = dao.fetchJobseekerConfidentialityProfile(USER_ID);
    
    List<ConfidentialPhrase> phrases;
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.Name);
    assertEquals(0, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertTrue(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.PhoneNumber);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.EmailAddress);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.MailingAddress);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.ContactInfo);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.CompanyName);
    assertEquals(0, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertTrue(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategories.WorkExperience);
    assertEquals(0, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertTrue(phrase.isConfidential());
    }
    
  }

}
