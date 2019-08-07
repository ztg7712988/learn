package com.dbms.article.service.serviceimpl;

import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.entity.FunctionTbl;
import com.dbms.article.mapper.CategoryMapper;
import com.dbms.article.service.CategoryListService;
import com.dbms.article.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CategoryListServiceimpl implements CategoryListService {

    @Autowired
    CategoryMapper mapper;

    //获取分类和功能列表
    @Override
    public List<CategoryTbl> getFunctionAndCategory() {
        //获取功能和文章分类表
        List<CategoryTbl> tbls = mapper.selectCategoryAndFunctionMap1();
        return tbls;
    }
    //删除分类表记录
    @Override
    public int deleteCategory(int id) {
        return mapper.deleteCategory(id);
    }
}
