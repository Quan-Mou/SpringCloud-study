package com.quan.sentinel.service;




import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.pagehelper.PageInfo;
import com.quan.sentinel.bean.Vip;
import com.quan.sentinel.result.R2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "provider-config-002-8083",
        path = "/vip"
        )
public interface VipService {
    @GetMapping("/{id}")
    Vip getVipById(@PathVariable("id") Long id);

    @GetMapping("/list/{pageNO}")
    R2<PageInfo<Vip>> list(@PathVariable("pageNO") Integer pageNO);
}
