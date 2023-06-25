package com.zyx.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyx.ssyx.model.product.SkuAttrValue;
import com.zyx.ssyx.product.mapper.SkuAttrValueMapper;
import com.zyx.ssyx.product.service.SkuAttrValueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuAttrValueServiceImpl extends ServiceImpl<SkuAttrValueMapper, SkuAttrValue> implements SkuAttrValueService {
    /**
     * @param skuId
     * @return
     */
    @Override
    public List<SkuAttrValue> findBySkuId(Long skuId) {
       LambdaQueryWrapper<SkuAttrValue> queryWrapper = new LambdaQueryWrapper<>();
       queryWrapper.eq(SkuAttrValue::getSkuId, skuId);
       return baseMapper.selectList(queryWrapper);
    }
}
