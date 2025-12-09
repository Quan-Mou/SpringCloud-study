package com.quan.provider.controller;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quan.provider.constant.StatuEnum;
import com.quan.provider.entity.Vip;
import com.quan.provider.result.R1;
import com.quan.provider.result.R2;
import com.quan.provider.service.VipService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vip")
@RestController
public class VipController {


    @Resource
    private VipService vipService;


    /**
     * 根据id删除vip
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R2<?> deleteById(@PathVariable("id") Long id) {
        int row = vipService.deleteById(id);
        if(row == 0) {
            return R2.fail(StatuEnum.DELETE.getMsg());
        }
        return R2.OK();
    }

    /**
     * 新增VIP信息
     * @param vip
     * @return
     */
    @PostMapping("/")
    public R2<?> InsertVip(@RequestBody Vip vip) {
        int row = vipService.insertVip(vip);
        if(row == 0) {
            return R2.fail(StatuEnum.INSERT.getMsg());
        }
        return R2.OK();
    }


    @PutMapping("/")
    public R2<?> updateVip(@RequestBody Vip vip) {
        int row = vipService.updateById(vip);
        if(row == 0) {
            return R2.fail(StatuEnum.INSERT.getMsg());
        }
        return R2.OK();
    }

    @GetMapping("/{id}")
    public Vip getVipById(@PathVariable("id") Long id) {
        Vip vip = vipService.getVipById(id);
        return vip;
    }






    /**
     * 统一响应格式
     * @param pageNO
     * @return
     */
    @GetMapping("/list/{pageNO}")
    public R2<PageInfo<Vip>> list(@PathVariable("pageNO") Integer pageNO) {
        PageHelper.startPage(pageNO,2);
        List<Vip> vips = vipService.list();
        PageInfo<Vip> vipPageInfo = new PageInfo<>(vips);
        return R2.OK(vipPageInfo);
    }

//    @GetMapping("/vip/list/{pageNO}")
//    public PageInfo<Vip> list(@PathVariable("pageNO") Integer pageNO) {
//        PageHelper.startPage(pageNO,2);
//        List<Vip> vips = vipService.list();
////       把数据封装到PageInfo
//        PageInfo<Vip> vipPageInfo = new PageInfo<>(vips);
//        return vipPageInfo;
//    }




}
