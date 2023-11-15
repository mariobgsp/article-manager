package com.example.articlemanager.repository;

import com.example.articlemanager.model.rqrs.ArticleRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(ArticleRequest article) {
        entityManager.createNativeQuery("INSERT INTO articles (title, body, author) VALUES (?,?,?)")
                .setParameter(1, article.getTitle())
                .setParameter(2, article.getBody())
                .setParameter(3, article.getAuthor())
                .executeUpdate();
    }
}
