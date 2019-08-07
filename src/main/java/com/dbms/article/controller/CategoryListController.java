package com.dbms.article.controller;

import com.dbms.article.entity.CategoryTbl;
import com.dbms.article.entity.FunctionTbl;
import com.dbms.article.service.CategoryListService;
import com.dbms.article.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 分类列表Controller
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/api/rest")
public class CategoryListController {

    @Autowired
    CategoryListService service;//获取文章分类列表service

    //查询分类信息
    @RequestMapping("/categories/list")
    public List<CategoryTbl> getCategoryList(){
        return service.getFunctionAndCategory();
    }

    /**
     * @RequestMapping中定义了/index1/{id}，那么获取到的id就是index1/后的数据。
     * 例如我的url是/getParam/index1/123,那么id=123。
     * @Param id 分类id
     * @return
     */
    @RequestMapping(value = "/categories/delete/{id}",method = RequestMethod.DELETE)
    public Object deleteCategory(@PathVariable(value = "id")int id){
        ResultInfo result = new ResultInfo();
        try {
            if(service.deleteCategory(id)!=0){
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
}
