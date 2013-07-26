package com.theladders.solid.dip;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestSubscriberArticleManagerImpl
{
  private final Integer subscriberId = new Integer(1);

  private SuggestedArticleRepository repository;
  private RepositoryManager repositoryManager;
  private SubscriberArticleManagerImpl subscriberArticleManager;
  
  private enum ArticleStatus
  {
    NEW(1),
    VIEWED(2),
    READ(3); // TODO: Find actual ID for non-new, non-viewed statuses.
    
    private final int statusId;
    
    private ArticleStatus(int statusId)
    {
      this.statusId = statusId;
    }
    
    public int id()
    {
      return this.statusId;
    }
  }
  
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
  
  @Test
  public void testAddingAndThenGettingMultipleArticles()
  {
    givenAManager();
    whenIAddASuggestedArticleForASubscriber();
    whenIAddASuggestedArticleForASubscriber();
    thenICanGetTheRightNumberOfArticlesSuggestedForASubscriber(2);
  }
  
  @Test
  public void testGettingOnlyNewOrViewedArticles()
  {
    givenAManager();
    whenIAddASuggestedArticleForASubscriber();
    whenIAddASuggestedButNotNewOrViewedArticle();
    thenICanGetTheRightNumberOfArticlesSuggestedForASubscriber(1);
  }

  public void givenAManager()
  {
    repository = new InMemorySuggestedArticleRepository();
    repositoryManager = new RepositoryManager();
    subscriberArticleManager = new SubscriberArticleManagerImpl(repository, repositoryManager);
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
  
  private void whenIAddASuggestedButNotNewOrViewedArticle()
  {
    String articleExternalIdentifier = "An Identifier";
    String note = "Blank Note";
    Integer adminUserId = new Integer(999);
    
    SuggestedArticle article = new SuggestedArticle(subscriberId,
                                                    articleExternalIdentifier,
                                                    note,
                                                    adminUserId);
    article.setSuggestedArticleStatusId(ArticleStatus.READ.id());
    
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
