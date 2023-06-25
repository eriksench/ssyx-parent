package com.zyx.ssyx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.ssyx.model.product.SkuAttrValue;

import java.util.List;

public interface SkuAttrValueService extends IService<SkuAttrValue> {
    List<SkuAttrValue> findBySkuId(Long skuId);
}
