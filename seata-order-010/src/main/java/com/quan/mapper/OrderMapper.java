package com.quan.mapper;

import com.quan.bean.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    @Insert("insert into `order`(goods_id,amount,count,account_id) values(#{goodsId},#{amount},#{count},#{accountId})")
    Integer save(Order order);
}
