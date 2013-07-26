package com.theladders.solid.dip;

import java.util.List;

public interface SuggestedArticleRepository
{
  public abstract int addArticle(SuggestedArticle article);
  
  public abstract List<SuggestedArticle> fetchArticlesByCriteria(SuggestedArticleSearchCriteria criteria);

  public abstract void updateArticle(SuggestedArticle article);
}
