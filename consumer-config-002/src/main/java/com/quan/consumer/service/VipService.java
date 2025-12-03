package com.quan.consumer.service;


import com.quan.consumer.bean.Vip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-config-002-8083",path = "/vip")
public interface VipService {

    @GetMapping("/{id}")
    Vip getVipById(@PathVariable("id") Long id);

}
