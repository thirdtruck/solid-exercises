package com.theladders.solid.dip;

import java.util.*;

public class SuggestedArticleDao
{
  private Map<Integer, SuggestedArticle> articlesBySubscriberId;
  
  public SuggestedArticleDao()
  {
    articlesBySubscriberId = new HashMap<Integer, SuggestedArticle>();
  }
  
  public void updateByPrimaryKeySelective(@SuppressWarnings("unused") SuggestedArticle article) {}

  public int insertReturnId(@SuppressWarnings("unused") SuggestedArticle suggestedArticle)
  {
    articlesBySubscriberId.put(suggestedArticle.getSubscriberId(), suggestedArticle);
    return 0;
  }

  public List<SuggestedArticle> selectByExampleWithBlobs(@SuppressWarnings("unused") SuggestedArticleExample criteria)
  {
    return new ArrayList<SuggestedArticle>(articlesBySubscriberId.values());
  }
}
