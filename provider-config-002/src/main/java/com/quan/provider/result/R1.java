package com.quan.provider.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class R1<T> {
    private String msg;
    private Integer code;
    private T data;

//    成功的方法、失败的方法
    public static <T> R1<T> OK() {

        return R1.<T>builder().build();

//        R<T> r = new R<>();
//        r.setCode(200);
//        r.setMsg("success");
//        return r;
    }

    public static <T> R1<T> OK(T data) {
        R1<T> r = new R1<>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    public static <T> R1<T> OK(String msg) {
        R1<T> r = new R1<>();
        r.setCode(200);
        r.setMsg(msg);
        return r;
    }

    public static <T> R1<T> OK(String msg, T data) {
        R1<T> r = new R1<>();
        r.setCode(200);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }


//   失败的方法
    public static <T> R1<T> fail(){
        R1<T> r = new R1<>();
        r.setCode(400);
        r.setMsg("fail");
        return r;
    }

    public static <T> R1<T> fail(String msg){
        R1<T> r = new R1<>();
        r.setCode(400);
        r.setMsg(msg);
        return r;
    }

//    错误的方法不需要返回数据
    public static <T> R1<T> fail(Integer code, String msg){
        R1<T> r = new R1<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }


}
