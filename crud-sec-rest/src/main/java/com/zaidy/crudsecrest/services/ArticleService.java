package com.zaidy.crudsecrest.services;

import com.zaidy.crudsecrest.model.Article;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ArticleService
{
    //List<Article> getAllArticles();
   // Article getArticleById(Long articleId) throws Exception;
  //  Article addArticle(Article article);
  //  Article updateArticle(Article article);
   // void deleteArticle(Long articleId);
    boolean articleExists(String title, String category);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    List<Article> getAllArticles();
    @Secured ({"ROLE_ADMIN", "ROLE_USER"})
    Article getArticleById(Long articleId) throws Exception;
    @Secured ({"ROLE_ADMIN"})
    Article addArticle(Article article);
    @Secured ({"ROLE_ADMIN"})
    Article updateArticle(Article article);
    @Secured ({"ROLE_ADMIN"})
    void deleteArticle(Long articleId);
}
