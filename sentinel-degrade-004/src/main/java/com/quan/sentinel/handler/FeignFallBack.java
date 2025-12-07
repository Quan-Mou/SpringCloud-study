package com.quan.sentinel.handler;

import com.quan.sentinel.bean.Vip;
import com.quan.sentinel.service.VipService;
import org.springframework.stereotype.Component;

@Component
public class FeignFallBack implements VipService {
    @Override
    public Vip getVipById(Long id) {
        Vip vip = new Vip();
        vip.setName("执行Feign类式的降级方法");
        return vip;
    }
}
