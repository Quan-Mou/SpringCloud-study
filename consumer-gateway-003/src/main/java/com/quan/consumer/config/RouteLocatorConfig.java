package com.quan.consumer.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

@Configuration
public class RouteLocatorConfig {

//        @Bean
//        public RouteLocator afterRouter(RouteLocatorBuilder builder) {
//            ZonedDateTime now = ZonedDateTime.now().minusDays(3);
//            RouteLocator afterRoute = builder.routes().route("after_route",
//
//    //              path的意思是访问/test/下的任意路径、层级请求地址，都跳转到 uri（lb://provider-config-002-8083） 这个请求下
//    //                lb://provider-config-002-8083/test/**
//                    fn ->
//                            fn.path("/test/**")
//                                    .and().after(now).uri("lb://provider-config-002-8083")
//                    ).build();
//            return afterRoute;
//        }



//    @Bean
//    public RouteLocator pathRouter(RouteLocatorBuilder builder) {
//        RouteLocator jdRoute = builder.routes()
//                .route("jd_route",
//                fn -> fn.path("/jdd").uri("http://jd.com")
//                )
//                .route("tb_route",
//                        fn -> fn.path("/tbb").uri("http://taobao.com"))
//                .route("bd_route",
//                        fn -> fn.path("/bdd").uri("http://baidu.com"))
//                .build();
//
//        return jdRoute;
//    }
}
