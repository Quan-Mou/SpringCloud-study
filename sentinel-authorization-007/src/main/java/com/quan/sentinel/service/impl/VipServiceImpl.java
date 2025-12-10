package com.quan.sentinel.service.impl;




import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.github.pagehelper.PageInfo;
import com.quan.sentinel.bean.Vip;
import com.quan.sentinel.result.R2;
import com.quan.sentinel.service.VipService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class VipServiceImpl {

    @Resource
    private VipService vipService;

    @SentinelResource(value = "list",blockHandler = "listBlockHandler")
    public R2<PageInfo<Vip>> list(Integer pageNO) {
        return vipService.list(pageNO);
    }

    public R2<PageInfo<Vip>> listBlockHandler(Integer pageNO, BlockException e) {
        R2<PageInfo<Vip>> list = vipService.list(pageNO);
        list.setData(null);
        list.setMsg("flow limit" + e);
        list.setCode(429);
        return  list;
    }



    @SentinelResource(value = "getVipById",fallback = "getVipByIdFallBackHandler")
    public Vip getVipById( Long id) {
        return vipService.getVipById(id);
    }

    // 熔断/降级处理方法
    public Vip getVipByIdFallBackHandler(Long id,Throwable throwable) {
        Vip vip = new Vip();
        vip.setName("这是该请求的降级处理方法");
        vip.setId(100L);
        return vip;
    }

}
