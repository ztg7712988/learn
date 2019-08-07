package com.dbms.article.service;

import com.dbms.article.entity.FunctionTbl;
import com.dbms.article.util.ResultInfo;

import java.util.List;

// 功能接口
public interface  FunctionService {

    List<FunctionTbl> getListUI();
}
