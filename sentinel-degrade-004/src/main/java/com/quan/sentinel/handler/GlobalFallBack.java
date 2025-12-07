package com.quan.sentinel.handler;

import com.quan.sentinel.bean.Vip;

/**
 * Sentinel类级降级
 */
public class GlobalFallBack {

    /**
     * 方法名必须是静态的
     */
    public static Vip getVipByIdFallBack(Long id,Throwable t) {
        Vip vip = new Vip();
        vip.setName("降级处理方法-Sentinel类级");
        vip.setCardNumber(t.getMessage());
        return vip;
    }


}
