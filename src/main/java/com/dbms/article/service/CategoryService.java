package com.dbms.article.service;

import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.util.ResultInfo;

import java.util.List;

//文章分类接口
public interface CategoryService {

    boolean saveCategory(CategoryTbl category);

    List<CategoryTbl> getCategoryByAll();

    ResultInfo getCategoryById(int id);

    int updateCateCategory(CategoryTbl categoryTbl);
}
