package com.zaidy.crudsecrest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="articles")
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="article_id")
    private Long articleId;
    @Column(name="title")
    private String title;
    @Column(name="category")
    private String category;

}