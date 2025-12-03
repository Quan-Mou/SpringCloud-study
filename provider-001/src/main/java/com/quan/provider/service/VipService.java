package com.quan.provider.service;


import com.quan.provider.entity.Vip;

import java.util.List;

public interface VipService {

    List<Vip> list();

    /**
     * 根据id删除vip
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据id查询vip
     * @return
     */
    Vip getVipById(Long id);

    /**
     * 根据id修改vip信息
     * @param vip
     * @return
     */
    int updateById(Vip vip);

    int insertVip(Vip vip);

}
