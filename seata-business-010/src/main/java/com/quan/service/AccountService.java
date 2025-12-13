package com.quan.service;

import com.quan.bean.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-010",path = "transaction")
public interface AccountService {


    @GetMapping("/")
    int purchase(@RequestParam("accountName") String accountName,
                        @RequestParam("amount") double amount);

    @GetMapping("/getAccount")
    Account getAccount(@RequestParam("accountName") String accountName);
}
