package com.example.articlemanager.delivery;

import com.example.articlemanager.model.Article;
import com.example.articlemanager.model.rqrs.ArticleRequest;
import com.example.articlemanager.repository.ArticleInsertRepository;
import com.example.articlemanager.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleInsertRepository articleInsertRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addArticles(@RequestBody ArticleRequest articleRq) {
        List<Article> articles = articleRepository.findAll();
        for (Article article : articles) {
            if (article.getTitle().equals(articleRq.getTitle())) {
                return ResponseEntity.badRequest().body("Article with this title already exists");
            }
        }

        articleInsertRepository.insertWithQuery(articleRq);
        return ResponseEntity.ok("Article added successfully");
    }

    @PostMapping("/add/bulk")
    public ResponseEntity<?> addBulkArticle(@RequestBody List<ArticleRequest> articleRequest){
        for (ArticleRequest article : articleRequest) {
            articleInsertRepository.insertWithQuery(article);
        }
        return ResponseEntity.ok("Article added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllArticles() {
        return ResponseEntity.ok(articleRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Long id) {
        return ResponseEntity.ok(articleRepository.findById(id));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable Long id, @RequestBody ArticleRequest article) {
        Article newArticle = articleRepository.findById(id).get();
        newArticle.setAuthor(article.getAuthor());
        newArticle.setBody(article.getBody());
        newArticle.setTitle(article.getTitle());
        articleRepository.save(newArticle);
        return ResponseEntity.ok("Article updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return ResponseEntity.ok("Article deleted successfully");
    }

}
