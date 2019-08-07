package com.dbms.article.mapper;

import com.dbms.article.entity.ArticleTbl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<ArticleTbl> seclectArticleByAll();

    int delecteArticleById(String id);

    ArticleTbl seclectArticleById(String id);

    int insertArticle(ArticleTbl articleTbl);

    ArticleTbl seclectArticleByTitle(String title);

    int updateArticle(ArticleTbl articleTbl);

    List<ArticleTbl> findFiveArticle(int id);

}
