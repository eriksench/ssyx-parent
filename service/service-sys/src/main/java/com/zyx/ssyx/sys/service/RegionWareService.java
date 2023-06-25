package com.zyx.ssyx.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.ssyx.model.sys.RegionWare;
import com.zyx.ssyx.vo.sys.RegionWareQueryVo;

public interface RegionWareService extends IService<RegionWare> {
    /**
     * 开通区域列表
     * @param pageParam
     * @param regionWareQueryVo
     * @return
     */
    IPage<RegionWare> selectPage(Page<RegionWare> pageParam, RegionWareQueryVo regionWareQueryVo);

    /**
     * 添加开通区域
     * @param regionWare
     */
    void saveRegionWare(RegionWare regionWare);

    /**
     * 取消开通区域
     * @param id
     * @param status
     */
    void updateStatus(Long id, Integer status);
}
