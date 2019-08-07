package com.dbms.article.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Setter
@Getter
public class CategoryTbl implements Serializable {
    private int id;

    private String name;

    private int parent;

    private Date crateTime;

    private Date updateTime;

    private FunctionTbl functionTbl;//功能对象

    private List<ArticleTbl> functionTbls = new ArrayList<ArticleTbl>();//文章分类

}