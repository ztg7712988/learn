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
public class FunctionTbl implements Serializable {
    private Integer id;

    private String name;//功能名

    private String img;//图片URL

    private Date created;//创建日期

    private Date updated;

    private String description;//描述

    private List<CategoryTbl> categoryTbls = new ArrayList<CategoryTbl>();//分类信息

}