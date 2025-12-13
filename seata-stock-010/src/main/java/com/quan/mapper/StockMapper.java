package com.quan.mapper;

import com.quan.bean.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StockMapper {

    @Select("select * from stock where goods_id = #{goodsId}")
    Stock getGoodsCount(@Param("goodsId")Integer goodsId);
}