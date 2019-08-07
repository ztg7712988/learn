package com.dbms.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.entity.FunctionTbl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//文章分类接口
@Mapper
public interface CategoryMapper{

    Integer insertCategory(CategoryTbl category);

    List<CategoryTbl> selectCategoryByAll();

    List<FunctionTbl> selectCategoryAndFunctionMap();

    int deleteCategory(int id);

    CategoryTbl selectFunCateById(int id);

    int updateCategoty(CategoryTbl categoryTbl);

    List<CategoryTbl> selectCategoryAndFunctionMap1();

    FunctionTbl selectCategoryById(int id);

    CategoryTbl selectCategoryByName(String name);

}
