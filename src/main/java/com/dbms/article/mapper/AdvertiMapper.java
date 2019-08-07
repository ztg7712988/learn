package com.dbms.article.mapper;

import com.dbms.article.entity.AdTbl;
import com.dbms.article.entity.LinkTbl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdvertiMapper {

    int insertOnechLink(LinkTbl linkTbl);

    int insetAd(AdTbl tbl);

    AdTbl findAdvertiByname(String name);

    List<AdTbl> findAdvertiByAll();

    AdTbl findAdvertiById(String id);

    int deleteAdTbl(String id);

    int deleteLinkTbl(String id);

    int updateAdverti(AdTbl adTbl);
}
