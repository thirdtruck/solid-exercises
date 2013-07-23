import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfile;
import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfileDao;
import com.theladders.solid.ocp.resume.ConfidentialPhrase;
import com.theladders.solid.ocp.resume.ConfidentialPhraseCategory;
import com.theladders.solid.ocp.resume.ConfidentialResumeHandler;
import com.theladders.solid.ocp.resume.JobseekerProfileManager;
import com.theladders.solid.ocp.user.User;


public class TestConfidentialResumeHandler
{

  private JobseekerProfileManager            profileManager;
  private JobseekerConfidentialityProfileDao dao;
  
  private ConfidentialResumeHandler          handler;
  
  private final int                          USER_ID = 1;                  
  private User                               user;
  
  
  @Before
  public void setUp()
  {
    profileManager = new JobseekerProfileManager();
    dao = new JobseekerConfidentialityProfileDao();
    
    user = new User(USER_ID);
    
    handler = new ConfidentialResumeHandler(profileManager, dao);
  }

  @Test
  public void testMakesAllCategoriesPublic()
  {
    handler.makeAllCategoriesNonConfidential(user);
    
    JobseekerConfidentialityProfile profile = dao.fetchJobSeekerConfidentialityProfile(USER_ID);
    
    List<ConfidentialPhrase> phrases;
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.Name);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    profile.getPublicPhrases(ConfidentialPhraseCategory.PhoneNumber);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.EmailAddress);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.MailingAddress);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.ContactInfo);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.CompanyName);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.WorkExperience);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
  }

  @Test
  public void testMakesContactCategoriesPublic()
  {
    handler.makeAllCategoriesNonConfidential(user);
    
    JobseekerConfidentialityProfile profile = dao.fetchJobSeekerConfidentialityProfile(USER_ID);
    
    List<ConfidentialPhrase> phrases;
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.Name);
    assertEquals(0, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertTrue(phrase.isConfidential());
    }
    
    profile.getPublicPhrases(ConfidentialPhraseCategory.PhoneNumber);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.EmailAddress);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.MailingAddress);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.ContactInfo);
    assertEquals(1, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertFalse(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.CompanyName);
    assertEquals(0, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertTrue(phrase.isConfidential());
    }
    
    phrases = profile.getPublicPhrases(ConfidentialPhraseCategory.WorkExperience);
    assertEquals(0, phrases.size());
    for(ConfidentialPhrase phrase : phrases)
    {
      assertTrue(phrase.isConfidential());
    }
    
  }

}
