package com.quan.controller;

import com.quan.bean.Account;
import com.quan.bean.Goods;
import com.quan.bean.Order;
import com.quan.service.AccountService;
import com.quan.service.GoodsService;
import com.quan.service.OrderService;
import com.quan.service.StockService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 仅做测试，各服务就不写Controller调用Service层了
 * 直接在Controller中写业务逻辑
 */
@RestController
public class GoodsController {


    @Resource
    private StockService stockService;;

    @Resource
    private AccountService accountService;;

    @Resource
    private OrderService orderService;

    @Resource
    private GoodsService goodsService;

    @GetMapping("/goodsPurchase")
    public String goodsPurchase(
            @RequestParam("goodsId") Integer goodsId,
            @RequestParam("count") Integer count,
            @RequestParam("accountName") String accountName
    ) {

//        1.调用库存服务，判断库充是否充足
        Integer stock = stockService.getStock(goodsId, count);
        if(stock == 0) {
            return "该商品库存不足";
        }
//        2.调用账户服务，判断余额是否充足
        Account account = accountService.getAccount(accountName);
            if(account == null) {
            return "账户不存在";
        }

        Goods goods = goodsService.getGoodsById(goodsId);
        Double totalMonetary = count * goods.getPrice();

        if(account.getBalance() < totalMonetary) {
            return "账户余额不足";
        }
//        3.调用账户服务扣减金额 在调用订单服务生成订单，

//       扣减金额
        int result = accountService.purchase(accountName, totalMonetary);
        if(result == 0) {
            return "支付失败！";
        }
        Order order = new Order();
        order.setGoodsId(goodsId);
        order.setAccountId(account.getId());
        order.setCount(count);
        order.setAmount(totalMonetary);
//       生成订单
        Integer orderStatus = orderService.generateOrder(order);
        if(orderStatus == 0) {
            return "订单创建失败！";
        }
        return "购买成功！";
    }

}
