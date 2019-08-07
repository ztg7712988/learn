package com.dbms.article.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ListUI implements Serializable {


    private Integer id;//功能主键
    private String name;//功能名

    public void  ListUI(){}
}
