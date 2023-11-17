package com.example.articlemanager.delivery;

import com.example.articlemanager.config.AppProperties;
import com.example.articlemanager.model.rqrs.ArticleRequest;
import com.example.articlemanager.model.rqrs.GenericResponse;
import com.example.articlemanager.usecase.ArticleUsecase;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleUsecase articleUsecase;

    @Autowired
    private AppProperties appProperties;

    @PostMapping("/add")
    public ResponseEntity<?> addArticles(
            @RequestHeader(name = "Authorization", required = false) String authorization,
            @RequestParam(name = "apiKey", required = false) String apiKey,
            @RequestBody ArticleRequest articleRq) {

        if(appProperties.isEnableAuth()){
            if(authorization == null || !authorization.equals(appProperties.getSecretKey())){
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setFailed(HttpStatus.UNAUTHORIZED , "Unauthorized");
                return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
            }
        }else if(appProperties.isEnableApiKey()){
            if(apiKey == null || !apiKey.equals(appProperties.getApiKey())){
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setFailed(HttpStatus.UNAUTHORIZED , "Unauthorized");
                return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
            }
        }

        GenericResponse genericResponse = articleUsecase.addArticles(articleRq);
        return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllArticles(
                @RequestHeader(name = "Authorization", required = false) String authorization,
                @RequestParam(name = "apiKey", required = false) String apiKey,
                @RequestParam(name = "page", required = false) Integer page, 
                @RequestParam(name="size", required = false) Integer size
                ) {

        if(appProperties.isEnableAuth()){
            if(authorization == null || !authorization.equals(appProperties.getSecretKey())){
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setFailed(HttpStatus.UNAUTHORIZED , "Unauthorized");
                return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
            }
        }else if(appProperties.isEnableApiKey()){
            if(apiKey == null || !apiKey.equals(appProperties.getApiKey())){
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setFailed(HttpStatus.UNAUTHORIZED , "Unauthorized");
                return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
            }
        }

        if(page == null && size == null){
            page = 0;
            size = 0;
        }else if (page == null) {
            page = 1;
        }else if (size == null) {
            size = 10;
        }

        GenericResponse genericResponse = articleUsecase.getAllArticle(page, size);
        return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticleById(
            @RequestHeader(name = "Authorization", required = false) String authorization,
            @RequestParam(name = "apiKey", required = false) String apiKey,
            @PathVariable Long id) {

        if(appProperties.isEnableAuth()){
            if(authorization == null || !authorization.equals(appProperties.getSecretKey())){
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setFailed(HttpStatus.UNAUTHORIZED , "Unauthorized");
                return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
            }
        }else if(appProperties.isEnableApiKey()){
            if(apiKey == null || !apiKey.equals(appProperties.getApiKey())){
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setFailed(HttpStatus.UNAUTHORIZED , "Unauthorized");
                return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
            }
        }

        GenericResponse genericResponse = articleUsecase.getArticleById(id);
        return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateArticle(
            @RequestHeader(name = "Authorization", required = false) String authorization,
            @RequestParam(name = "apiKey", required = false) String apiKey,
            @PathVariable Long id, @RequestBody ArticleRequest article) {

        if(appProperties.isEnableAuth()){
            if(authorization == null || !authorization.equals(appProperties.getSecretKey())){
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setFailed(HttpStatus.UNAUTHORIZED , "Unauthorized");
                return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
            }
        }else if(appProperties.isEnableApiKey()){
            if(apiKey == null || !apiKey.equals(appProperties.getApiKey())){
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setFailed(HttpStatus.UNAUTHORIZED , "Unauthorized");
                return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
            }
        }

        CompletableFuture.runAsync(()->articleUsecase.updateArticle(article, id));
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setSuccessMsg("Article Updated Successfully");
        return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArticle(
            @RequestHeader(name = "Authorization", required = false) String authorization,
            @RequestParam(name = "apiKey", required = false) String apiKey,
            @PathVariable Long id) {

        if(appProperties.isEnableAuth()){
            if(authorization == null || !authorization.equals(appProperties.getSecretKey())){
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setFailed(HttpStatus.UNAUTHORIZED , "Unauthorized");
                return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
            }
        }else if(appProperties.isEnableApiKey()){
            if(apiKey == null || !apiKey.equals(appProperties.getApiKey())){
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setFailed(HttpStatus.UNAUTHORIZED , "Unauthorized");
                return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
            }
        }


        CompletableFuture.runAsync(()->articleUsecase.deleteArticleById(id));
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setSuccessMsg("Article Deleted Successfully");
        return ResponseEntity.status(genericResponse.getHttpStatusCode()).body(genericResponse);
    }
}
