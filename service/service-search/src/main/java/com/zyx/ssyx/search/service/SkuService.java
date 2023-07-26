package com.zyx.ssyx.search.service;

import com.zyx.ssyx.model.search.SkuEs;
import com.zyx.ssyx.vo.search.SkuEsQueryVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface SkuService {

    /**
     * 上架商品列表
     * @param skuId
     */
    void upperSku(Long skuId);

    /**
     * 下架商品列表
     * @param skuId
     */
    void lowerSku(Long skuId);
}