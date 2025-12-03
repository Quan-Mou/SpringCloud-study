package com.quan.provider.service.impl;


import com.quan.provider.entity.Vip;
import com.quan.provider.mapper.VipMapper;
import com.quan.provider.service.VipService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipServiceImpl implements VipService {


    @Resource
    private VipMapper vipMapper;

    @Override
    public List<Vip> list() {
        List<Vip> vips = vipMapper.list();
        return vips;
    }

    @Override
    public int deleteById(Long id) {
        return vipMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Vip getVipById(Long id) {
        return vipMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(Vip vip) {
        return vipMapper.updateByPrimaryKey(vip);
    }

    @Override
    public int insertVip(Vip vip) {
       return vipMapper.insert(vip);
    }


}
