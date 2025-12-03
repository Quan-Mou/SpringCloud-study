package com.quan.consumer.controller;


import com.quan.consumer.bean.Vip;
import com.quan.consumer.service.VipService;
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


        @GetMapping("/vip/{id}")
        public Vip getVipById(@PathVariable("id") Long id) {
            Vip vipById = vipService.getVipById(id);
            return vipById;
        }
    }
