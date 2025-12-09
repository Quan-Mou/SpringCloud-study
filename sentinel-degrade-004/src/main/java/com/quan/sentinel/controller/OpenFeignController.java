package com.quan.sentinel.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.quan.sentinel.bean.Vip;
import com.quan.sentinel.handler.GlobalFallBack;
import com.quan.sentinel.service.VipService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class OpenFeignController {

    @Resource
    private VipService vipService;


//    @SentinelResource(fallback = "getVipByIdFallBack")
//    @SentinelResource(fallback = "getVipByIdFallBack",fallbackClass = GlobalFallBack.class)
    @GetMapping("/vip/{id}")
    public Vip getVipById(@PathVariable("id") Long id) {
        Vip vipById = vipService.getVipById(id);
        return vipById;
    }

//    public Vip getVipByIdFallBack(Long id,Throwable t) {
//        Vip vip = new Vip();
//        vip.setName("降级处理方法");
//        vip.setCardNumber(t.getMessage());
//        return vip;
//    }
}
