package com.zyx.ssyx.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyx.ssyx.model.product.Attr;
import com.zyx.ssyx.product.mapper.AttrMapper;
import com.zyx.ssyx.product.service.AttrService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements AttrService {
    /**
     * 根据属性分组id 获取属性列表
     *
     * @param attrGroupId
     * @return
     */
    @Override
    public List<Attr> findByAttrGroupId(Long attrGroupId) {
        LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attr::getAttrGroupId,attrGroupId);
        List<Attr> attrList = baseMapper.selectList(wrapper);
        return attrList;
    }
}
