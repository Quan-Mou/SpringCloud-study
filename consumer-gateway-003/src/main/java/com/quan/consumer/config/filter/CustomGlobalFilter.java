package com.quan.consumer.config.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 *
 * 需求:访问当前系统的任意模块的 URL 都需要是合法的 URL。这里所谓
 * 合法的 URL 指的是请求中携带了 author 请求参数。
 */
@Component
public class CustomGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        if (!queryParams.containsKey("author")) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//          返回响应
            return exchange.getResponse().setComplete();
        }
//      只要请求中存在token请求参数即可放行
        return chain.filter(exchange);
    }
}
