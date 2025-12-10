package com.quan.sentinel.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quan.sentinel.bean.Vip;
import com.quan.sentinel.result.R2;
import com.quan.sentinel.service.VipService;
import com.quan.sentinel.service.impl.VipServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/feign")
public class OpenFeignController {

    @Resource
    private VipServiceImpl vipService;




    @GetMapping("/vip/list/{pageNO}")
    public R2<PageInfo<Vip>> list(@PathVariable("pageNO") Integer pageNO) {
        return  vipService.list(pageNO);
    }


    @GetMapping("/vip/all/{pageNO}")
    public R2<PageInfo<Vip>> listAll(@PathVariable("pageNO") Integer pageNO) {
        return  vipService.list(pageNO);
    }



    @GetMapping("/vip/{id}")
    public Vip getVipById(@PathVariable("id") Long id) {
        Vip vipById = vipService.getVipById(id);
        return vipById;

    }

    @GetMapping("/vip/test")
    @SentinelResource(value = "test",fallback = "testHandler")
    public String test(@RequestParam String name){
        return "text success" + name;
    }


    public String testHandler(String name){
        return "text fail" + name;
    }


}
