package com.dbms.article.service;

import com.dbms.article.entity.AdTbl;

import java.util.List;

public interface AdvertiService {

    boolean newAdverti(AdTbl tbl);

    List<AdTbl> findAdvertiByAll();

    AdTbl findAdvertiByID(String id);

    boolean deleteAdverti(String id);

    boolean updateAdverti(String id,AdTbl adTbl);

}
