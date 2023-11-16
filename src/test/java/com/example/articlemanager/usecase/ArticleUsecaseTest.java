package com.example.articlemanager.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;

import com.example.articlemanager.model.Article;
import com.example.articlemanager.model.rqrs.ArticleRequest;
import com.example.articlemanager.model.rqrs.GenericResponse;
import com.example.articlemanager.repository.ArticleInsertRepository;
import com.example.articlemanager.repository.ArticleRepository;

public class ArticleUsecaseTest {


    @Mock
    private ArticleInsertRepository articleInsertRepository;
    @Mock
    private ArticleRepository articleRepository;

    @Spy
    @InjectMocks
    private ArticleUsecase articleUsecaseUnderTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testAddArticles() {
        
        
        // Setup
        Article article = new Article();
        article.setAuthor("author");
        article.setBody("body");
        article.setTitle("title");
        article.setId(3L);

        List<Article> articles = new ArrayList<>();
        articles.add(article);
        Mockito.doReturn(articles).when(articleRepository).findAll();
        Mockito.doNothing().when(articleInsertRepository).insertWithQuery(Mockito.any(ArticleRequest.class));
        
        // Run the test
        GenericResponse genericResponse = articleUsecaseUnderTest.addArticles(new ArticleRequest("title-test", "body-test", "author-test"));
        
        // Verify the results
        assertEquals(HttpStatus.OK, genericResponse.getHttpStatusCode());
    }

    @Test
    void testDeleteArticleById() {

        // Setup
        Article article = new Article(); 
        article.setAuthor("author");
        article.setBody("body");
        article.setTitle("title");

        List<Article> articles = new ArrayList<>();
        articles.add(article);
        
        Mockito.doReturn(Optional.of(article)).when(articleRepository).findById(Mockito.any(Long.class));
        Mockito.doNothing().when(articleRepository).deleteById(Mockito.any(Long.class));

        // Run the test
        GenericResponse genericResponse = articleUsecaseUnderTest.deleteArticleById(0L);

        // Verify the results
        assertEquals(HttpStatus.OK, genericResponse.getHttpStatusCode());
    }

    @Test
    void testGetAllArticle() {

        // Setup
        Article article = new Article();
        article.setAuthor("author");
        article.setBody("body");
        article.setTitle("title");
        
        List<Article> articles = new ArrayList<>();
        articles.add(article);

        Mockito.doReturn(articles).when(articleRepository).findAll();

        // Run the test
        GenericResponse genericResponse = articleUsecaseUnderTest.getAllArticle(0, 0);

        // Verify the results
        assertEquals(HttpStatus.OK, genericResponse.getHttpStatusCode());


    }

    @Test
    void testGetArticleById() {

        // Setup
        Article article = new Article();
        article.setAuthor("author");
        article.setBody("body");
        article.setTitle("title");
    
        List<Article> articles = new ArrayList<>();
        articles.add(article);

        Mockito.doReturn(Optional.of(articles)).when(articleRepository).findById(Mockito.any(Long.class));

        // Run the test
        GenericResponse genericResponse = articleUsecaseUnderTest.getArticleById(0L);

        // Verify the results
        assertEquals(HttpStatus.OK, genericResponse.getHttpStatusCode());
    
    }

    @Test
    void testUpdateArticle() {
        
        // Setup
        Article article = new Article();
        article.setAuthor("author");
        article.setBody("body");
        article.setTitle("title");

        List<Article> articles = new ArrayList<>();
        articles.add(article);

        Mockito.doReturn(Optional.of(article)).when(articleRepository).findById(Mockito.any(Long.class));
        Mockito.doReturn(article).when(articleRepository).save(Mockito.any(Article.class));

        // Run the test
        GenericResponse genericResponse = articleUsecaseUnderTest.updateArticle(new ArticleRequest("title-test", "body-test", "author-test"), 0L );

        // Verify the results
        assertEquals(HttpStatus.OK, genericResponse.getHttpStatusCode());

    }
}
