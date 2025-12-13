package com.quan.mapper;

import com.quan.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountMapper {

    @Select("select * from account where account = #{accountName}")
    Account getAccount(@Param("accountName") String accountName);

    @Update("update account set balance = #{amount} where account = #{accountName}")
    int purchase(@Param("accountName") String accountName, @Param("amount") double amount);
}
