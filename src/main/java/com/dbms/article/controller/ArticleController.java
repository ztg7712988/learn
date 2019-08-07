package com.dbms.article.controller;

import com.dbms.article.entity.ArticleTbl;
import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.service.ArticleService;
import com.dbms.article.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/api/rest")
public class ArticleController {

    @Autowired
    ArticleService service;


    //查询文章列表接口 ;
    @RequestMapping(value = "/articles/list",method = RequestMethod.GET)
    public List<ArticleTbl> getCategoryList(){
        return service.selectArticleByAll();
    }

    //删除文章
    @RequestMapping(value = "/articles/delete/{id}" ,method = RequestMethod.DELETE)
    public Object deleteArticle(@PathVariable(value = "id")String id){
        ResultInfo result = new ResultInfo();
        try {
            if(service.delecteArticleById(id)!=0){
                result.setMessage("删除成功！");
                result.setStatusCode(1);
            }else{
                result.setMessage("删除失败！");
                result.setStatusCode(0);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage("系统异常！");
            result.setStatusCode(0);
        }
        return result;
    }

    //加载文章和文章分类信息
    @RequestMapping(value = "/articles/edit/{id}",method = RequestMethod.GET)
    public ArticleTbl getArticleUI(@PathVariable(value = "id")String  id){
        return service.findArticleById(id);
    }

    //编辑文章
    @RequestMapping(value = "/articles/edit/{id}",method = RequestMethod.POST)
    public ResultInfo updateArticle(@RequestBody ArticleTbl tbl) {
        ResultInfo result = new ResultInfo();
        ArticleTbl articleTbl = tbl;
        tbl.setUpdated(new Date());
        try{
            if (service.updateArticle(tbl)!=0){
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

    //新建文章分类
    @RequestMapping(value = "/articles/create",method = RequestMethod.POST)
    public Object createArticle(@RequestBody ArticleTbl articleTbl){
        ResultInfo<ArticleTbl> resultInfo = new ResultInfo<ArticleTbl>();
        try {
            boolean is = service.newArticle(articleTbl);
            if (is) {
                resultInfo.setMessage("保存成功");
                resultInfo.setStatusCode(1);
            } else {
                resultInfo.setMessage("添加失败，文章名已存在");
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
