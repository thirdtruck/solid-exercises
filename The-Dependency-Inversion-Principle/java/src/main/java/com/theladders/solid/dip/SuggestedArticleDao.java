package com.theladders.solid.dip;

import java.util.Collections;
import java.util.List;

public class SuggestedArticleDao implements SuggestedArticleRepository
{
  public void updateByPrimaryKeySelective(@SuppressWarnings("unused") SuggestedArticle article) {}

  public int insertReturnId(@SuppressWarnings("unused") SuggestedArticle suggestedArticle)
  {
    return 0;
  }

  public List<SuggestedArticle> selectByExampleWithBlobs(@SuppressWarnings("unused") SuggestedArticleSearchCriteria criteria)
  {
    return Collections.singletonList(new SuggestedArticle());
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
