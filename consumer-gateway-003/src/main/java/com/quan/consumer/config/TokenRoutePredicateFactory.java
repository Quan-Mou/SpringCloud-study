package com.quan.consumer.config;


import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;


/**
 * 自定义断言工厂，
 */
@Component
public class TokenRoutePredicateFactory  extends AbstractRoutePredicateFactory<TokenRoutePredicateFactory.config> {
    public TokenRoutePredicateFactory() {
        super(TokenRoutePredicateFactory.config.class);
    }


    @Override
    public Predicate<ServerWebExchange> apply(config config) {
        return serverWebExchange -> {
            MultiValueMap<String, String> queryParams = serverWebExchange.getRequest().getQueryParams();
            List<String> token = queryParams.get("token");
            if(token.contains(config.getToken())){
                return true;
            }
            return false;
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("token");
    }

    @Data
    public static class config {
        private String token;
    }
}
