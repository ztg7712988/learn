package com.dbms.article.controller;

import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.service.CategoryService;
import com.dbms.article.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/api/rest")
public class CategoryEditController {

    @Autowired
    CategoryService service;

    //根据id查询文章信息
    @RequestMapping(value = "/categories/edit/{id}",method = RequestMethod.GET)
    public ResultInfo getEditCategory(@PathVariable(value = "id")int id){
        return service.getCategoryById(id);
    }

    /**
     * 保存编辑文章
     * id：分类id
     * name：分类名
     * c_id：功能id
     */
    @RequestMapping(value = "/categories/edit/{id}",method = RequestMethod.POST)
    public ResultInfo updateCategory(@PathVariable(value = "id")int id, @RequestParam(value = "name")String name,
                                     @RequestParam(value = "parent")int c_id){
        ResultInfo result = new ResultInfo();
        CategoryTbl categoryTbl = new CategoryTbl();
        categoryTbl.setId(id);
        categoryTbl.setUpdateTime(new Date());
        categoryTbl.setName(name);
        categoryTbl.setParent(c_id);
        try{
            if (service.updateCateCategory(categoryTbl)!=0){
                result.setMessage("更新成功！");
                result.setStatusCode(1);
            }else {
                result.setMessage("更新失败！");
                result.setStatusCode(0);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("系统异常！");
            result.setStatusCode(0);
        }
        return result;
    }
}
