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
        //将表封装到ResultInfo中
        /*for (FunctionTbl functionTbl:tbls){
            for(CategoryTbl categoryTbl:functionTbl.getCategoryTbls()){
                *//*ResultInfo<CategoryTbl> info = new ResultInfo<CategoryTbl>();
                info.setToken(functionTbl.getName());//封装功能名
                info.setData(categoryTbl);//封装文章分类对象
                results.add(info);*//*
                list.put(functionTbl.getName(),categoryTbl);
            }
        }*/
        return tbls;
    }
    //删除分类表记录
    @Override
    public int deleteCategory(int id) {
        return mapper.deleteCategory(id);
    }
}
