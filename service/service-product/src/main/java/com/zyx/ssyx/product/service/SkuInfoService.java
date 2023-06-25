package com.zyx.ssyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.ssyx.model.product.SkuInfo;
import com.zyx.ssyx.vo.product.SkuInfoQueryVo;
import com.zyx.ssyx.vo.product.SkuInfoVo;

public interface SkuInfoService extends IService<SkuInfo> {

    /**
     * 获取sku分页列表
     * @param pageParam
     * @param skuInfoQueryVo
     * @return
     */
    IPage<SkuInfo> selectPage(Page<SkuInfo> pageParam, SkuInfoQueryVo skuInfoQueryVo);

    /**
     * 添加商品
     * @param skuInfoVo
     */
    void saveSkuInfo(SkuInfoVo skuInfoVo);

    /**
     * 获取商品
     * @return
     */
    SkuInfoVo getSkuInfoVo(Long skuId);

    /**
     * 修改商品
     */
    void updateSkuInfo(SkuInfoVo skuInfoVo);

    /**
     * 商品审核
     * @param skuId
     * @param status
     */
    void check(Long skuId, Integer status);

    /**
     * 商品上架
     * @param skuId
     * @param status
     */
    void publish(Long skuId, Integer status);

    /**
     * 新人专享
     * @param skuId
     * @param status
     */
    void isNewPerson(Long skuId, Integer status);
}
