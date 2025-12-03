package com.quan.provider.controller;


import com.quan.provider.result.R2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Value("${vip.name}")
    private String vipName;

    @Value("${vip.age}")
    private Integer age;

    @Value("${server.port}")
    private Integer prot;

    @Value("${spring.application.name}")
    private String applicationName;


    @GetMapping("/dynamicReceiveConfig")
    public R2<?> dynamicReceiveConfig() {
        return R2.OK("vipName:" + vipName + ", age:" + age + ", prot:" + prot + ", applicationName:" + applicationName);
    }
}
