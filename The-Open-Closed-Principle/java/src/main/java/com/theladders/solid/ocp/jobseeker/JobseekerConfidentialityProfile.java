package com.theladders.solid.ocp.jobseeker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.theladders.solid.ocp.resume.ConfidentialPhrase;
import com.theladders.solid.ocp.resume.ConfidentialPhraseCategory;

public class JobseekerConfidentialityProfile
{
  private Map<String, List<ConfidentialPhrase>> confidentialityProfile;

  public JobseekerConfidentialityProfile()
  {
    confidentialityProfile = new HashMap<>();
  }

  public boolean markCategoryPhrasesAsPublic(ConfidentialPhraseCategory category)
  {
    boolean isChanged = false;

    List<ConfidentialPhrase> phrases = this.getConfidentialPhrases(category);
    if (phrases != null)
    {
      for (ConfidentialPhrase phrase : phrases)
      {
        if (phrase.isConfidential())
        {
          phrase.setConfidential(false);
          isChanged = true;
        }
      }
    }

    return isChanged;
  }
  
  public List<ConfidentialPhrase> getPublicPhrases(ConfidentialPhraseCategory category)
  {
    List<ConfidentialPhrase> publicPhrases = new ArrayList<ConfidentialPhrase>();
    
    List<ConfidentialPhrase> phrases = this.getConfidentialPhrases(category);
    if (phrases != null)
    {
      for (ConfidentialPhrase phrase : phrases)
      {
        if (phrase.isConfidential())
        {
          publicPhrases.add(phrase);
        }
      }
    }
    
    return publicPhrases;
  }

  private List<ConfidentialPhrase> getConfidentialPhrases(ConfidentialPhraseCategory category)
  {
    return confidentialityProfile.get(category.name());
  }
}
