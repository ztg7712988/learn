package com.dbms.article.service.serviceimpl;

import com.dbms.article.entity.AdTbl;
import com.dbms.article.entity.LinkTbl;
import com.dbms.article.mapper.AdvertiMapper;
import com.dbms.article.service.AdvertiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//广告service
@Service
public class AdvertiServiceimpl implements AdvertiService {

    @Autowired
    AdvertiMapper mapper;

    //新建广告
    @Override
    public boolean newAdverti(AdTbl tbl) {
        if(mapper.findAdvertiByname(tbl.getName())!=null){
            return false;
        }
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String id = format.format(now);
        String idName = id + UUID.randomUUID();
        tbl.setId(idName);//ID
        tbl.setCrateTime(new Date());//时间
        tbl.setUpdateTime(new Date());

        mapper.insetAd(tbl);//插入广告标题
        for (LinkTbl linkTbl:tbl.getLinks()){
            mapper.insertOnechLink(linkTbl);//插入广告位
        }
        return true;
    }

    //查询所有的广告
    @Override
    public List<AdTbl> findAdvertiByAll() {
        return mapper.findAdvertiByAll();
    }

    //根据id查询广告
    @Override
    public AdTbl findAdvertiByID(String id) {
        return mapper.findAdvertiById(id);
    }

    @Override
    public boolean deleteAdverti(String id) {
        if (mapper.deleteAdTbl(id)==0){
            return false;
        }
        mapper.deleteLinkTbl(id);
        return true;
    }

    @Override
    public boolean updateAdverti(String id, AdTbl adTbl) {
        if(mapper.updateAdverti(adTbl)!=0){
            mapper.deleteLinkTbl(id);
            for(LinkTbl tbl:adTbl.getLinks()){
                mapper.insertOnechLink(tbl);
            }
            return true;
        }
        return false;
    }
}
