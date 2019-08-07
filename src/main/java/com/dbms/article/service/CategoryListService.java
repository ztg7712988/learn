package com.dbms.article.service;

import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.entity.FunctionTbl;
import com.dbms.article.util.ResultInfo;

import java.util.List;
import java.util.Map;

public interface CategoryListService {

    List<CategoryTbl> getFunctionAndCategory();

    int deleteCategory(int id);
}
