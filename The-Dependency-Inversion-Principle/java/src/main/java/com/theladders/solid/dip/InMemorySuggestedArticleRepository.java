package com.theladders.solid.dip;

import java.util.*;

public class InMemorySuggestedArticleRepository implements SuggestedArticleRepository
{
  private Map<Integer, List<SuggestedArticle>> articlesBySubscriberId;
  
  public InMemorySuggestedArticleRepository()
  {
    articlesBySubscriberId = new HashMap<Integer, List<SuggestedArticle>>();
  }

  @Override
  public int addArticle(SuggestedArticle article)
  {
    Integer subscriberId = article.getSubscriberId();
    List<SuggestedArticle> articles = articlesBySubscriberId.get(subscriberId);
    if(articles == null)
    {
      articles = new ArrayList<SuggestedArticle>();
    }
    articles.add(article);
    articlesBySubscriberId.put(subscriberId, articles);

    return 0;
  }

  @Override
  public List<SuggestedArticle> fetchArticlesByCriteria(SuggestedArticleSearchCriteria criteria)
  {
    ArrayList<SuggestedArticle> filteredArticles = new ArrayList<SuggestedArticle>();
    for(List<SuggestedArticle>articles : articlesBySubscriberId.values())
    {
      filteredArticles.addAll(articles);
    }
    return filteredArticles;
  }

  @Override
  public void updateArticle(SuggestedArticle article)
  {

  }
}
