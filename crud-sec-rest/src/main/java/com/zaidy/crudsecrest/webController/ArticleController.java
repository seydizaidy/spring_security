package com.zaidy.crudsecrest.webController;

import java.util.List;

import com.zaidy.crudsecrest.model.Article;
import com.zaidy.crudsecrest.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("user")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id) throws Exception {
        Article article = articleService.getArticleById(id);
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }
    @GetMapping("articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> list = articleService.getAllArticles();
        return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
    }
    @PostMapping("article")
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
              Article article1= articleService.addArticle(article);

            return new ResponseEntity<Article>(article1,HttpStatus.OK);
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
    @PutMapping("article/{id}")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article,@PathVariable("id") Long id)
    { article.setArticleId(id);
        articleService.updateArticle(article);
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }
    @DeleteMapping("article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}  