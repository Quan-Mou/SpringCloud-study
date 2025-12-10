package com.quan.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;
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
public class SentinelAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelAuthorizationApplication.class, args);


        initWhiteList(); // API式配置白名单

    }

    private static void initWhiteList() {
        List<AuthorityRule> rules = new ArrayList<>();
        AuthorityRule authorityRule = new AuthorityRule();
        authorityRule.setStrategy(RuleConstant.AUTHORITY_WHITE); // 白名单
        authorityRule.setLimitApp("mobile");
        authorityRule.setResource("list");
        rules.add(authorityRule);
        AuthorityRuleManager.loadRules(rules);
    }



}
