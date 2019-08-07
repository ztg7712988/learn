package com.dbms.article.service.serviceimpl;

import com.dbms.article.entity.ArticleTbl;
import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.entity.FunctionTbl;
import com.dbms.article.entity.ThreeUI;
import com.dbms.article.mapper.ArticleMapper;
import com.dbms.article.mapper.CategoryMapper;
import com.dbms.article.mapper.FunctionMapper;
import com.dbms.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//文章service
@Service
public class ArticleServiceimpl  implements ArticleService {
    @Autowired
    private CategoryMapper categoryMapper;//文章分类mapper
    @Autowired
    private ArticleMapper articleMapper;//文章内容mapper
    @Autowired
    private FunctionMapper functionMapper;//功能mapper

    //获取所有文章列表
    @Override
    public List<ArticleTbl> selectArticleByAll() {
        return articleMapper.seclectArticleByAll();
    }

    //删除文章列表
    @Override
    public int delecteArticleById(String id) {
        return articleMapper.delecteArticleById(id);
    }

    //根据id获取文章信息
    @Override
    public ArticleTbl findArticleById(String id) {
        return articleMapper.seclectArticleById(id);
    }

    @Override
    public boolean newArticle(ArticleTbl articleTbl) {

        //判断是否有相同的文章信息
        if (articleMapper.seclectArticleByTitle(articleTbl.getTitle()) != null){
            return false;
        }
        //id=UUID+时间
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String id = format.format(now);
        String idName = id + UUID.randomUUID();
        articleTbl.setId(idName);
        articleTbl.setCount(0);
        articleTbl.setUpdated(new Date());
        articleTbl.setCreatedAt(new Date());
        //保存成功
        articleMapper.insertArticle(articleTbl);
        return true;
    }

    @Override
    public int updateArticle(ArticleTbl articleTbl) {
        return articleMapper.updateArticle(articleTbl);
    }

    @Override
    public ThreeUI fiveArticle(int id) {
        ThreeUI UI = new ThreeUI();
        FunctionTbl functionTbl = functionMapper.selectFunctionById(id);
        List<ArticleTbl> articles = articleMapper.findFiveArticle(id);//获取文章

        UI.setName(functionTbl.getName());//获取功能名
        for (CategoryTbl categoryTbl:functionTbl.getCategoryTbls()){
            //获取分类名
            UI.getFunname().add(categoryTbl.getName());
        }
        UI.setArticles(articles);
        return UI;
    }
}
