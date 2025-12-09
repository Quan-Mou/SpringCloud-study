package com.quan.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class SentinelCircuitBreakApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelCircuitBreakApplication.class, args);

        initFallBackAndCircuitRule(); // API式配置熔断规则
        initFlowRule(); // API式配置流控规则
    }

    private static void initFlowRule() {
        List<FlowRule>  rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("getVipById"); // 资源名
        rule.setLimitApp("default"); // 针对来源
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS); // 阈值类型
        rule.setCount(2); // 单机阈值： 每秒只能访问两个请求以内。
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    public static void initFallBackAndCircuitRule() {
        List<DegradeRule>  rules = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule(); // 资源名
        degradeRule.setResource("getVipById");
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_RT); // 熔断策略：慢调用比例
        degradeRule.setCount(5); // 最大RT ResponseTime 5ms
        degradeRule.setMinRequestAmount(3); // 最小请求数
        degradeRule.setTimeWindow(10); // 熔断时长
        degradeRule.setStatIntervalMs(1000);//  统计时长
        degradeRule.setSlowRatioThreshold(0.3); // 比例阈值
        rules.add(degradeRule);
        DegradeRuleManager.loadRules(rules);
    }

}
