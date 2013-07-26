package com.theladders.solid.dip;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestSubscriberArticleManagerImpl
{
  private final Integer subscriberId = new Integer(1);

  private SuggestedArticleDao dao;
  private RepositoryManager repositoryManager;
  private SubscriberArticleManagerImpl subscriberArticleManager;
  
  @Test
  public void testGettingAnArticleFromANewManager()
  {
    givenAManager();
    thenICanGetTheRightNumberOfArticlesSuggestedForASubscriber(0);
  }
  
  @Test
  public void testAddingAndThenGettingArticles()
  {
    givenAManager();
    whenIAddASuggestedArticleForASubscriber();
    thenICanGetTheRightNumberOfArticlesSuggestedForASubscriber(1);
  }

  public void givenAManager()
  {
    dao = new SuggestedArticleDao();
    repositoryManager = new RepositoryManager();
    subscriberArticleManager = new SubscriberArticleManagerImpl(dao, repositoryManager);
  }
  
  private void whenIAddASuggestedArticleForASubscriber()
  {
    String articleExternalIdentifier = "An Identifier";
    String note = "Blank Note";
    Integer adminUserId = new Integer(999);
    
    SuggestedArticle article = new SuggestedArticle(subscriberId,
                                                    articleExternalIdentifier,
                                                    note,
                                                    adminUserId);
    subscriberArticleManager.addSuggestedArticle(article);
  }
  
  public void thenICanGetTheRightNumberOfArticlesSuggestedForASubscriber(int articleCount)
  {
    List<SuggestedArticle> articles = subscriberArticleManager.getArticlesbySubscriber(subscriberId);
    assertEquals(articleCount, articles.size());
  }
  
  @Before
  public void setup()
  {
  }

}
