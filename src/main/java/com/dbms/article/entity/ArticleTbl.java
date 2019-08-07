package com.dbms.article.entity;

import java.io.Serializable;
import java.util.Date;

public class ArticleTbl implements Serializable {
    private String id;

    private String title;//文章标题

    private String actor;//作者

    private Integer cuont;//点击量

    private String img;//图片路径

    private Integer  category;//分类

    private Date createdAt;//创建时间

    private Date updated;//更新时间

    private String context;//文章内容


}