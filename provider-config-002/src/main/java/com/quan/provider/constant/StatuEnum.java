package com.quan.provider.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


//@Getter
@AllArgsConstructor
@Getter
public enum StatuEnum {

    OK(200,"success"),
    FAIL(400,"fail"),

    DELETE(400,"删除失败"),
    INSERT(400,"新增失败"),

    UPDATE(400,"修改失败");

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private Integer code;
    private String msg;

}
