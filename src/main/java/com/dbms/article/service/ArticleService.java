package com.dbms.article.service;

import com.dbms.article.entity.ArticleTbl;
import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.entity.ThreeUI;

import java.util.List;

public interface ArticleService {

    List<ArticleTbl> selectArticleByAll();

    int delecteArticleById(String id);

    ArticleTbl findArticleById(String id);

    boolean newArticle(ArticleTbl articleTbl);

    int updateArticle(ArticleTbl articleTbl);

    ThreeUI fiveArticle(int id);

}
