package com.zaidy.crudsecrest.repositories;

import com.zaidy.crudsecrest.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository  extends JpaRepository<Article,Long>
{

}
