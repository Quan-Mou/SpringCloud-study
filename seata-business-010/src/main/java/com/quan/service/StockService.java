package com.quan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-stock-010",path = "stock")
public interface StockService {

    @GetMapping("/{goodsId}")
    Integer getStock(@PathVariable("goodsId") Integer goodsId,
                           @RequestParam("count") Integer count);
}
