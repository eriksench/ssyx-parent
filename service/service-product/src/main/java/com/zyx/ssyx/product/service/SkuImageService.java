package com.zyx.ssyx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.ssyx.model.product.SkuImage;

import java.util.List;

public interface SkuImageService extends IService<SkuImage> {
    List<SkuImage> findBySkuId(Long skuId);
}
