package com.dbms.article.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.mapper.CategoryMapper;
import com.dbms.article.service.CategoryService;
import com.dbms.article.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceimpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    //保存文章分类
    public boolean saveCategory(CategoryTbl category) {
        //获取所有分类信息
        List<CategoryTbl> list = categoryMapper.selectCategoryByAll();
        //判断是否有相同的分类信息
        for(CategoryTbl tbl:list){
            if (category.getName().equals(tbl.getName())){
                //存在相同的分类信息，保存失败
                return false;
            }
        }
        category.setCrateTime(new Date());//设置保存时间
        category.setUpdateTime(new Date());
        categoryMapper.insertCategory(category);
        //保存成功
        return true;
    }

    @Override
    //查询所有文章分类
    public List<CategoryTbl> getCategoryByAll() {

        return null;
    }


    @Override
    //根据id返回文章信息和父功能
    public ResultInfo<CategoryTbl> getCategoryById(int id) {
        ResultInfo<CategoryTbl> result = new ResultInfo<CategoryTbl>();
        CategoryTbl tbl = categoryMapper.selectFunCateById(id);
        //封装
        result.setData(tbl);
        return result;
    }

    @Override
    //更新文章分类信息
    public int updateCateCategory(CategoryTbl categoryTbl) {
        String name = categoryTbl.getName();//定义分类名
        //判断数据库中是否已有该分类名
        if(categoryMapper.selectCategoryByName(name) != null){
            return 0;
        }
        return categoryMapper.updateCategoty(categoryTbl);
    }
}
