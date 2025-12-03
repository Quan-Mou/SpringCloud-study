package com.quan.provider.result;

import com.quan.provider.constant.StatuEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class R2<T> {
    private String msg;
    private Integer code;
    private T data;

//    成功的方法、失败的方法

    public static <T> R2<T> OK() {
        R2<T> r = new R2<>();
        r.setCode(StatuEnum.OK.getCode());
        r.setMsg(StatuEnum.OK.getMsg());
        return r;
    }

    public static <T> R2<T> OK(T data) {
        R2<T> r = new R2<>();
        r.setCode(StatuEnum.OK.getCode());
        r.setMsg(StatuEnum.OK.getMsg());
        r.setData(data);
        return r;
    }



//   失败的方法
    public static <T> R2<T> fail(){
        R2<T> r = new R2<>();
        r.setCode(StatuEnum.FAIL.getCode());
        r.setMsg(StatuEnum.FAIL.getMsg());
        return r;
    }

    public static <T> R2<T> fail(String msg){
        R2<T> r = new R2<>();
        r.setCode(400);
        r.setMsg(msg);
        return r;
    }

//    错误的方法不需要返回数据,构建自定义的错误code和消息
    public static <T> R2<T> fail(StatuEnum statuEnum){
        R2<T> r = new R2<>();
        r.setCode(statuEnum.getCode());
        r.setMsg(statuEnum.getMsg());
        return r;
    }


}
