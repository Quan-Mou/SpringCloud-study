package com.quan.sentinel.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 配置针对来源
 */
@Component
public class FlowOriginConfig implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
//      约定好请求头参数：
        String facility = request.getHeader("facility");
        if (!StringUtils.hasText(facility)) {
            return "default";
        }
//      如果来源是移动设备，可以设置宽松的QPS
        if(facility.equals("mobile")){
            return "mobile";
        }
//      如果来源是PC设备，可以设置严格的QPS
        if(facility.equals("PC")){
            return "PC";
        }
        return "default";
    }
}
