package com.example.articlemanager.delivery;

import com.example.articlemanager.model.rqrs.ArticleRequest;
import com.example.articlemanager.model.rqrs.GenericResponse;
import com.example.articlemanager.usecase.ArticleUsecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleUsecase articleUsecase;

    @PostMapping("/add")
    public ResponseEntity<?> addArticles(@RequestBody ArticleRequest articleRq) {
        GenericResponse genericResponse = articleUsecase.addArticles(articleRq);
        return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllArticles(
                @RequestParam(name = "page", required = false) Integer page, 
                @RequestParam(name="size", required = false) Integer size
                ) {

        if(page == null && size == null){
            page = 0;
            size = 0;
        }else if (page == null && size != null) {
            page = 1;
        }else if (page != null && size == null) {
            size = 10;
        }

        GenericResponse genericResponse = articleUsecase.getAllArticle(page, size);
        return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Long id) {
        GenericResponse genericResponse = articleUsecase.getArticleById(id);
        return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable Long id, @RequestBody ArticleRequest article) {
        GenericResponse genericResponse = articleUsecase.updateArticle(article, id);
        return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        GenericResponse genericResponse = articleUsecase.deleteArticleById(id);
        return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
    }
}
