package com.quan.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
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
        initHotRule(); // API式配置热点规则
    }

    private static void initHotRule() {
        List<ParamFlowRule> paramFlowRules = new ArrayList<>();
        ParamFlowRule paramFlowRule = new ParamFlowRule();
        paramFlowRule.setResource("test"); // 资源名
        paramFlowRule.setParamIdx(0); // 参数索引
        paramFlowRule.setGrade(RuleConstant.FLOW_GRADE_QPS); // QPS模式
        paramFlowRule.setDurationInSec(10); // 统计窗口时长
        paramFlowRules.add(paramFlowRule);
        ParamFlowRuleManager.loadRules(paramFlowRules);

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
