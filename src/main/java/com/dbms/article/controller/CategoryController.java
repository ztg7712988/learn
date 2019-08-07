package com.dbms.article.controller;

import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.entity.FunctionTbl;
import com.dbms.article.service.CategoryService;
import com.dbms.article.service.FunctionService;
import com.dbms.article.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 新建文章controller层
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/api/rest")
public class CategoryController {

    @Autowired
    private FunctionService  functionService;//功能模块接口
    @Autowired
    private CategoryService categoryService;//文章模块接口

    //获取功能分类信息
    @RequestMapping(value = "/functions/list",method = RequestMethod.GET)
    public List<FunctionTbl> getListUI(){
        return functionService.getListUI();
    }


    /**
     * 新建分类信息
     * @parent:功能分类id
     * @name:文章分类名
     */
    @RequestMapping(value = "/categories/create",method = RequestMethod.POST)
    public Object insertCategory(@RequestBody CategoryTbl categoryTbl){
        CategoryTbl category = categoryTbl;
        /*category.setParent(parent);//外键
        category.setName(name);*/

       ResultInfo<CategoryTbl> resultInfo = new ResultInfo<CategoryTbl>();
       try {
           boolean is = categoryService.saveCategory(category);
           if (is) {
               resultInfo.setMessage("保存成功");
               resultInfo.setStatusCode(1);
           } else {
               resultInfo.setMessage("添加失败，分类已存在");
               resultInfo.setStatusCode(0);
           }
       }catch (Exception e){
           e.printStackTrace();
           resultInfo.setMessage("添加失败，系统异常");
           resultInfo.setStatusCode(0);
       }
       return resultInfo;
    }
}
