package com.quan.sentinel.service;



import com.quan.sentinel.bean.Vip;
import com.quan.sentinel.handler.FeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-config-002-8083",
        path = "/vip",
        fallback = FeignFallBack.class)
public interface VipService {

    @GetMapping("/{id}")
    Vip getVipById(@PathVariable("id") Long id);

}
