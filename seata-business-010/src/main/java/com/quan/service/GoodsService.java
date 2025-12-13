package com.quan.service;

import com.quan.bean.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "seata-order-010", path = "goods",contextId = "GoodsServiceClient")
public interface GoodsService {
    @GetMapping("/{goodsId}")
    Goods getGoodsById(@PathVariable("goodsId") Integer goodsId);
}
