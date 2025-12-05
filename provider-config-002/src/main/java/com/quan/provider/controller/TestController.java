package com.quan.provider.controller;


import com.quan.provider.result.R2;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
    public R2<?> dynamicReceiveConfig(HttpServletRequest request) {
        return R2.OK("vipName:" + vipName + ", age:" + age + ", prot:" + prot + ", applicationName:" + applicationName);
    }


    @GetMapping("/filters")
    public Map filters(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Enumeration<String> headerNames = request.getHeaderNames();
        HashMap<Object, Object> obj = new HashMap<>();
        obj.put("parameter", parameterMap);
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String header = request.getHeader(headerName);
            obj.put(headerName, header);
        }
        return obj;
    }





}
