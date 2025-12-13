package com.quan.mapper;

import com.quan.bean.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsMapper {

    @Select("select * from goods where id = #{goodsId}")
    Goods goodsById(@Param("goodsId") Integer goodsId);

}
