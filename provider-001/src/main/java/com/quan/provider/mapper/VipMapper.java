package com.quan.provider.mapper;



import com.quan.provider.entity.Vip;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Vip record);

    int insertSelective(Vip record);

    Vip selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Vip record);

    int updateByPrimaryKey(Vip record);

    List<Vip> list();
}