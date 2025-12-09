package com.quan.sentinel.controller;

import com.quan.sentinel.bean.Vip;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/goods")
public class GoodsController {



    @Resource
    private DiscoveryClient discoveryClient;
    private static final String serverAddr = "http://provider001-8083";


    @GetMapping("/services")
    @ResponseBody
    public List<String> getServices() {
        List<String> services = discoveryClient.getServices();
        for(String item : services){
            System.out.println("services item : " + item);
            for (ServiceInstance instance : discoveryClient.getInstances(item)) {
                System.out.println("instance host:" +instance.getHost());
                System.out.println("instance uri:" + instance.getUri());
                System.out.println("instance port:" + instance.getPort());
                System.out.println("instance scheme:" + instance.getScheme());
                System.out.println("instance serviceId:" + instance.getServiceId());
            }
        }
        return services;
    }


}
