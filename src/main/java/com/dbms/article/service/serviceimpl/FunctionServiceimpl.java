package com.dbms.article.service.serviceimpl;

import com.dbms.article.entity.FunctionTbl;
import com.dbms.article.mapper.FunctionMapper;
import com.dbms.article.service.FunctionService;
import com.dbms.article.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FunctionServiceimpl implements FunctionService {

    @Autowired
    private FunctionMapper functionMapper;

    @Override
    /*functionlMapper
    获取功能分类信息
     */
    public List<FunctionTbl> getListUI() {
        //获得查询结果
        List<FunctionTbl> list = functionMapper.selectByAll();

        //把查询结果封装到ResultInfo
        /*List<ResultInfo<FunctionTbl>> resultUI = new ArrayList<>();
        for (FunctionTbl functionTbl : list){
            ResultInfo<FunctionTbl> tbl = new ResultInfo<>();
            tbl.setData(functionTbl);
            resultUI.add(tbl);
        }*/
        //放回结果
        return list;
    }
}
