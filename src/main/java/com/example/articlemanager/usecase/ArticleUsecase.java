package com.example.articlemanager.usecase;

import java.util.List;

import com.example.articlemanager.model.rqrs.AddArticleRs;
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
                
                    genericResponse.setFailed(HttpStatus.CONFLICT, "Title already exist");
                    return genericResponse;
                }
            }
            // insert with query
            articleInsertRepository.insertWithQuery(articleRq);

            // get all article
            articles = articleRepository.findAll();

            // construct response
            AddArticleRs addArticleRs = new AddArticleRs();
            addArticleRs.setAuthor(articleRq.getAuthor());
            addArticleRs.setBody(articleRq.getBody());
            addArticleRs.setTitle(articleRq.getTitle());
            addArticleRs.setId(Math.toIntExact(articles.get(articles.size() - 1).getId()));

            genericResponse.setSuccess(addArticleRs);
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

    public GenericResponse getAllArticle(Integer page, Integer size){
        GenericResponse genericResponse = new GenericResponse();
        try{
            List<Article> articles = articleRepository.findAll();
            if(articles.isEmpty()){
                genericResponse.setFailed(HttpStatus.NOT_FOUND, "Article not found");
                return genericResponse;
            }
            if(page!=0 && size!=0){
                page = page - 1;
                int start = page * size;
                int end = start + size;
                if(end > articles.size()){
                    end = articles.size();
                }
                articles = articles.subList(start, end);
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
            List<Article> articles = articleRepository.findById(id).stream().toList();
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

    public GenericResponse deleteArticleById(Long id){
        GenericResponse genericResponse = new GenericResponse();
        try{
            List<Article> articles = articleRepository.findById(id).stream().toList();
            if(articles.isEmpty()){
                genericResponse.setFailed(HttpStatus.NOT_FOUND, "Article not found");
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
