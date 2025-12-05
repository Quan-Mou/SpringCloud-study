package com.quan.consumer.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义过滤工厂
 */
@Component
@Slf4j
public class AddHeaderGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {

        return ((exchange, chain) -> {
//          在执行filter之前执行的代码是属于pre部分
            long start = System.currentTimeMillis();
            System.out.println(config.getName());  // 在配置中定义的属性名
            System.out.println(config.getValue()); // 在配置中定义的属性值
            exchange.getAttributes().put("start", start);
            System.out.println("开始执行执行：" + start);
//          添加请求头
            ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().header(config.getName(), config.getValue()).build();
            ServerWebExchange build = exchange.mutate().request(serverHttpRequest).build();
            return chain.filter(build).then(Mono.fromRunnable(new Runnable() {
                @Override
                public void run() {
//                 这里是在执行filter之后的执行的代码，属于post部分
                   long start =  ((long) exchange.getAttribute("start"));
                    long time = System.currentTimeMillis() - start;
                    System.out.println("结束执行，耗时：" +  time);
                }
            }));
        });
    }
}
