package com.theladders.solid.dip;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestSubscriberArticleManagerImpl
{

  private SuggestedArticleDao dao;
  private RepositoryManager repositoryManager;
  private SubscriberArticleManagerImpl subscriberArticleManager;
  
  @Test
  public void testGettingAnArticle()
  {
    givenAManager();
    thenICanGetTheRightNumberOfArticlesSuggestedForASubscriber(1);
  }
  
  @Test
  public void testAddingAndThenGettingArticles()
  {
    givenAManager();
    whenIAddASuggestedArticleForASubscriber();
    thenICanGetTheRightNumberOfArticlesSuggestedForASubscriber(2);
  }

  public void givenAManager()
  {
    dao = new SuggestedArticleDao();
    repositoryManager = new RepositoryManager();
    subscriberArticleManager = new SubscriberArticleManagerImpl(dao, repositoryManager);
  }
  
  private void whenIAddASuggestedArticleForASubscriber()
  {
    SuggestedArticle article = new SuggestedArticle();
    subscriberArticleManager.addSuggestedArticle(article);
  }
  
  public void thenICanGetTheRightNumberOfArticlesSuggestedForASubscriber(int articleCount)
  {
    List<SuggestedArticle> articles = subscriberArticleManager.getArticlesbySubscriber(0);
    assertEquals(articleCount, articles.size());
  }
  
  @Before
  public void setup()
  {
  }

}
