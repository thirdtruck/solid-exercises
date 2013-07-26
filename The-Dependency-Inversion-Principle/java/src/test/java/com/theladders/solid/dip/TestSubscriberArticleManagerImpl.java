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
    thenICanGetTheArticleSuggestedForASubscriber();
  }
  
  public void givenAManager()
  {
    dao = new SuggestedArticleDao();
    repositoryManager = new RepositoryManager();
    subscriberArticleManager = new SubscriberArticleManagerImpl(dao, repositoryManager);
  }

  public void thenICanGetTheArticleSuggestedForASubscriber()
  {
    List<SuggestedArticle> articles = subscriberArticleManager.getArticlesbySubscriber(0);
    assertEquals(1, articles.size());
  }
  
  @Before
  public void setup()
  {
  }

}
