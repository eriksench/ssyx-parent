package com.zyx.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyx.ssyx.model.product.SkuImage;
import com.zyx.ssyx.product.mapper.SkuImageMapper;
import com.zyx.ssyx.product.service.SkuImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuImageServiceImpl extends ServiceImpl<SkuImageMapper, SkuImage> implements SkuImageService {

    /**
     * @param skuId
     * @return
     */
    @Override
    public List<SkuImage> findBySkuId(Long skuId) {
        LambdaQueryWrapper<SkuImage> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SkuImage::getSkuId, skuId);
        return baseMapper.selectList(queryWrapper);
    }
}
