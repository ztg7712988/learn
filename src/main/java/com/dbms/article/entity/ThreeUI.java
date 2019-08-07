package com.dbms.article.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Setter
@Getter
public class ThreeUI implements Serializable {
    private String name;//功能名

    private List<String> funname = new ArrayList<>();//分类名

    private List<ArticleTbl> articles;//文章

}
