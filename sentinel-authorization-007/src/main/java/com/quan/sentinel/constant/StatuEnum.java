package com.quan.sentinel.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


//@Getter
@Getter
public enum StatuEnum {

    OK(200,"success"),
    FAIL(400,"fail"),

    DELETE(400,"删除失败"),
    INSERT(400,"新增失败"),

    UPDATE(400,"修改失败");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    StatuEnum() {
    }

    StatuEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
