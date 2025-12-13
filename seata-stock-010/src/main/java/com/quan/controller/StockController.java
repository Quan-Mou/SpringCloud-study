package com.quan.controller;


import com.quan.bean.Stock;
import com.quan.mapper.StockMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/stock")
public class StockController {


    @Resource
    private StockMapper stockMapper;

    @GetMapping("/{goodsId}")
    public Integer getStock(@PathVariable("goodsId") Integer goodsId,
                            @RequestParam("count") Integer count) {

//      根据这个商品id和查询库存表中是否满足购买的商品库存
       Stock stock =  stockMapper.getGoodsCount(goodsId);
       if(stock == null){
          return 0;
       }
        return stock.getCount();
    }


}
