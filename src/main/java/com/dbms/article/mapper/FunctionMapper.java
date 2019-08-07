package com.dbms.article.mapper;

import com.dbms.article.entity.FunctionTbl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FunctionMapper {

    List<FunctionTbl> selectByAll();

    FunctionTbl selectFunctionById(int id);
}
