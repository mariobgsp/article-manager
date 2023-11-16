package com.example.articlemanager.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.example.articlemanager.model.Article;
import com.example.articlemanager.model.rqrs.ArticleRequest;
import com.example.articlemanager.model.rqrs.GenericResponse;
import com.example.articlemanager.repository.ArticleInsertRepository;
import com.example.articlemanager.repository.ArticleRepository;

@Repository
public class ArticleUsecase {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleInsertRepository articleInsertRepository;

    public GenericResponse addArticles(ArticleRequest articleRq) {
        GenericResponse genericResponse = new GenericResponse();
        
        try{
            List<Article> articles = articleRepository.findAll();
            for (Article article : articles) {
                if (article.getTitle().equals(articleRq.getTitle())) {
                
                    genericResponse.setFailed(HttpStatus.BAD_REQUEST, "Title already exist");
                    return genericResponse;
                }
            }

            articleInsertRepository.insertWithQuery(articleRq);

            genericResponse.setSuccessMsg("Article Inserted Successfully");
        }catch(Exception e){
            genericResponse.setFailed(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

        }

        return genericResponse;
       
    }

    public GenericResponse updateArticle(ArticleRequest article, Long id){
        GenericResponse genericResponse = new GenericResponse();
        try{

            Article newArticle = articleRepository.findById(id).get();
            newArticle.setAuthor(article.getAuthor());
            newArticle.setBody(article.getBody());
            newArticle.setTitle(article.getTitle());
            articleRepository.save(newArticle);

            genericResponse.setSuccessMsg("Article Updated Successfully");
        }catch(Exception e){
            genericResponse.setFailed(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return genericResponse;
    }

    public GenericResponse getAllArticle(){
        GenericResponse genericResponse = new GenericResponse();
        try{
            List<Article> articles = articleRepository.findAll();
            if(articles.isEmpty()){
                genericResponse.setFailed(HttpStatus.NOT_FOUND, "Article not found");
                return genericResponse;
            }

            genericResponse.setSuccess(articles);
        }catch(Exception e){
            genericResponse.setFailed(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());  

        }

        return genericResponse;
    }

    public GenericResponse getArticleById(Long id){
        GenericResponse genericResponse = new GenericResponse();
        try{
            Article article = articleRepository.findById(id).get();
            if(article == null){
                genericResponse.setFailed(HttpStatus.NOT_FOUND, "Article not found");
                return genericResponse;
            }

            genericResponse.setSuccess(article);
        }catch(Exception e){
            genericResponse.setFailed(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());   
        }

        return genericResponse;
    }

    public GenericResponse deleteArticleById(Long id){
        GenericResponse genericResponse = new GenericResponse();
        try{
            Article article = articleRepository.findById(id).get();
            if(article == null){
                genericResponse.setFailed(HttpStatus.INTERNAL_SERVER_ERROR, "Article not found"); 
                return genericResponse;
            }

            articleRepository.deleteById(id);

            genericResponse.setSuccessMsg("Article Deleted Successfully");
        }catch(Exception e){
            genericResponse.setFailed(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());  
        }

        return genericResponse;
    }

    
}
