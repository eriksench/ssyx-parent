package com.zyx.ssyx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.ssyx.model.product.SkuPoster;

import java.util.List;

public interface SkuPosterService extends IService<SkuPoster> {
    List<SkuPoster> findBySkuId(Long skuId);
}
