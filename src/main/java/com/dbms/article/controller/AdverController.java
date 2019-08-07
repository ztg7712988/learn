package com.dbms.article.controller;

import com.dbms.article.entity.AdTbl;
import com.dbms.article.entity.ArticleTbl;
import com.dbms.article.service.AdvertiService;
import com.dbms.article.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/api/rest")
public class AdverController {

    @Autowired
    AdvertiService service;

    //创建广告
    @RequestMapping(value = "/advers/create",method = RequestMethod.POST)
    public Object createAdverti(@RequestBody AdTbl adTbl){
        ResultInfo<ArticleTbl> resultInfo = new ResultInfo<ArticleTbl>();
        try {
            boolean is = service.newAdverti(adTbl);
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

    //查询所有广告
    @RequestMapping(value = "/advers/list",method = RequestMethod.GET)
    public List<AdTbl> findAll(){
        return service.findAdvertiByAll();
    }

    //根据ID查询广告
    @RequestMapping(value = "/advers/edit/{id}",method = RequestMethod.GET)
    public AdTbl findAdvertiByid(@PathVariable(value = "id")String id){
        return service.findAdvertiByID(id);
    }

    //保存编辑广告
    @RequestMapping(value = "/advers/edit/{id}",method = RequestMethod.POST)
    public ResultInfo updateAdverti(@PathVariable(value = "id")String id,@RequestBody AdTbl adTbl){
        ResultInfo result = new ResultInfo();
        AdTbl ad = adTbl;
        ad.setUpdateTime(new Date());
        try{
            if (service.updateAdverti(id,adTbl)){
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

    //删除广告
    @RequestMapping(value = "/advers/delete/{id}",method = RequestMethod.DELETE)
    public Object deleteAdTblWithLinkTbl(@PathVariable(value = "id")String id) {
        ResultInfo result = new ResultInfo();
        try {
            if(service.deleteAdverti(id)){
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
