package com.quan.sentinel.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.github.pagehelper.PageInfo;
import com.quan.sentinel.bean.Vip;
import com.quan.sentinel.result.R2;
import com.quan.sentinel.service.VipService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class OpenFeignController {

    @Resource
    private VipService vipService;


//    @SentinelResource(value = "getVipById",blockHandler = "getVipByIdBlockHandler",fallback = "getVipByIdFallBackHandler")
    @SentinelResource(value = "getVipById",blockHandler = "getVipByIdBlockHandler" )
    @GetMapping("/vip/{id}")
    public Vip getVipById(@PathVariable("id") Long id) {
        Vip vipById = vipService.getVipById(id);
        return vipById;
    }
    // 流控处理方法
    public Vip getVipByIdBlockHandler(Long id,BlockException e) {
        Vip vip = new Vip();
        vip.setName("执行流控代码");
        vip.setId(100L);
        return vip;
    }

    // 熔断/降级处理方法
    public Vip getVipByIdFallBackHandler(Long id,Throwable throwable) {
        Vip vip = new Vip();
        vip.setName("这是该请求的降级处理方法");
        vip.setId(100L);
        return vip;
    }


    @SentinelResource(value = "list")
    @GetMapping("/vip/list/{pageNO}")
    public R2<PageInfo<Vip>> list(@PathVariable("pageNO") Integer pageNO) {
        return vipService.list(pageNO);
    }




}
