package com.zyx.ssyx.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.ssyx.model.product.Attr;

import java.util.List;

public interface AttrService extends IService<Attr> {

    /**
     * 根据属性分组id 获取属性列表
     * @param attrGroupId
     * @return
     */
    List<Attr> findByAttrGroupId(Long attrGroupId);
}
