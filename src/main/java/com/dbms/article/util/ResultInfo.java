package com.dbms.article.util;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ResultInfo<T> implements Serializable {

    /**
     * 错误信息
     */
    private String message;
    /**
     * 错误号
     */
    private Integer statusCode;
    /**
     * token
     */
    private Object token;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 总记录数
     */
    private int count;

}
