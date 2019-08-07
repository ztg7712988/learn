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
public class AdTbl implements Serializable {
    private String id;

    private String name;

    private String description;

    private Date crateTime;

    private Date updateTime;

    private List<LinkTbl> links = new ArrayList<>();
}
