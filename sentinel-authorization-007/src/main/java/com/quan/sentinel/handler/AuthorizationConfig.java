package com.quan.sentinel.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 配置 授权规则
 */
@Component
public class AuthorizationConfig implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        if (!StringUtils.hasText(request.getHeader("x-origin"))) {
            return "default";
        }
        return request.getHeader("x-origin"); // 如mobile、pc
    }
}
