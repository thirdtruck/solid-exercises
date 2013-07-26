package com.theladders.solid.dip;

import java.util.*;

public class SuggestedArticleDao implements SuggestedArticleRepository
{
  private Map<Integer, List<SuggestedArticle>> articlesBySubscriberId;
  
  public SuggestedArticleDao()
  {
    articlesBySubscriberId = new HashMap<Integer, List<SuggestedArticle>>();
  }
  
  public void updateByPrimaryKeySelective(@SuppressWarnings("unused") SuggestedArticle article) {}

  public int insertReturnId(@SuppressWarnings("unused") SuggestedArticle suggestedArticle)
  {
    Integer subscriberId = suggestedArticle.getSubscriberId();
    List<SuggestedArticle> articles = articlesBySubscriberId.get(subscriberId);
    if(articles == null)
    {
      articles = new ArrayList<SuggestedArticle>();
    }
    articles.add(suggestedArticle);
    articlesBySubscriberId.put(subscriberId, articles);
    return 0;
  }

  public List<SuggestedArticle> selectByExampleWithBlobs(@SuppressWarnings("unused") SuggestedArticleSearchCriteria criteria)
  {
    ArrayList<SuggestedArticle> filteredArticles = new ArrayList<SuggestedArticle>();
    for(List<SuggestedArticle>articles : articlesBySubscriberId.values())
    {
      filteredArticles.addAll(articles);
    }
    return filteredArticles;
  }

  @Override
  public int addArticle(SuggestedArticle article)
  {
    return insertReturnId(article);
  }

  @Override
  public List<SuggestedArticle> fetchArticlesByCriteria(SuggestedArticleSearchCriteria criteria)
  {
    return selectByExampleWithBlobs(criteria);
  }

  @Override
  public void updateArticle(SuggestedArticle article)
  {
    updateByPrimaryKeySelective(article);
  }
}
