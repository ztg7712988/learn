package com.dbms.article.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Setter
@Getter
public class LinkTbl implements Serializable {
    private String parent;

    private String img;

    private String url;

    private AdTbl adTbl;
}
