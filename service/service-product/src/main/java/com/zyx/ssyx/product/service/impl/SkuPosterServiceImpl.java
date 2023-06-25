package com.zyx.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyx.ssyx.model.product.SkuPoster;
import com.zyx.ssyx.product.mapper.SkuPosterMapper;
import com.zyx.ssyx.product.service.SkuPosterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuPosterServiceImpl extends ServiceImpl<SkuPosterMapper, SkuPoster> implements SkuPosterService {
    /**
     * @param skuId
     * @return
     */
    @Override
    public List<SkuPoster> findBySkuId(Long skuId) {
       LambdaQueryWrapper<SkuPoster> queryWrapper = new LambdaQueryWrapper<>();
       queryWrapper.eq(SkuPoster::getSkuId, skuId);
       return baseMapper.selectList(queryWrapper);
    }
}
