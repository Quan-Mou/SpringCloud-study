package com.quan.controller;

import com.quan.bean.Account;
import com.quan.mapper.AccountMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {


    @Resource
    private AccountMapper accountMapper;


    /**
     * 获取账户
     * @param accountName 账户名
     * @return
     */
    @GetMapping("/getAccount")
    public Account getAccount(@RequestParam("accountName") String accountName) {
        return accountMapper.getAccount(accountName);
    }


    @GetMapping("/")
    public int purchase(@RequestParam("accountName") String accountName,
                              @RequestParam("amount") double amount) {

        Account account = accountMapper.getAccount(accountName);
        if(account == null){
            throw new RuntimeException("账户不存在");
        }

        double accountBalance = account.getBalance() - amount;
        return accountMapper.purchase(accountName,accountBalance);
    }


}
