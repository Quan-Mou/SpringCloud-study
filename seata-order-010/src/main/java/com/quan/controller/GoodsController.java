package com.quan.controller;

import com.quan.bean.Goods;
import com.quan.mapper.GoodsMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {


    @Resource
    private GoodsMapper goodsMapper;;

    @GetMapping("/{goodsId}")
    public Goods getGoodsById(@PathVariable("goodsId") Integer goodsId) {
        return goodsMapper.goodsById(goodsId);
    }
}
