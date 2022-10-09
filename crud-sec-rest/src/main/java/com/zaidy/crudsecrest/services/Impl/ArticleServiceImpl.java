package com.zaidy.crudsecrest.services.Impl;

import com.zaidy.crudsecrest.model.Article;
import com.zaidy.crudsecrest.repositories.ArticleRepository;
import com.zaidy.crudsecrest.services.ArticleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository)
    {
        this.articleRepository = articleRepository;
    }


    @Override
    public List<Article> getAllArticles()
    {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long articleId) throws Exception {
        Article article=articleRepository.findById(articleId).orElse(null);
        if (article == null) throw new Exception("Article Not Found Exeption");
        return article;
    }

    @Override
    public Article addArticle(Article article)
    {
        return articleRepository.save(article);

    }

    @Override
    public Article updateArticle(Article article)
    {
       return articleRepository.save(article);
    }
    @Override
    public void deleteArticle(Long articleId)
    {
        articleRepository.deleteById(articleId);

    }

    @Override
    public boolean articleExists(String title, String category) {
        return false;
    }
}
