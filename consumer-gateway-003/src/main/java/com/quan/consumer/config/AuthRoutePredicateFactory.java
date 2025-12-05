package com.quan.consumer.config;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class AuthRoutePredicateFactory extends AbstractRoutePredicateFactory<AuthRoutePredicateFactory.Config> {

    public AuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
//          ServerWebExchange 这个参数中封装了请求的上下文。返回一个Predicate，这是函数式接口
        return new Predicate<ServerWebExchange>() {

            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                HttpHeaders headers = serverWebExchange.getRequest().getHeaders();
                List<String> username = headers.get("userName");
                List<String> password = headers.get("password");
                if (username.contains(config.getUserName()) && password.contains(config.getPassword())) {
                    return true;
                }
                return false;
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
//      指定在配置时的顺序
        return Arrays.asList("userName","password");
    }

    @Data
    public static class Config {
        private String userName;
        private String password;
    }

}
