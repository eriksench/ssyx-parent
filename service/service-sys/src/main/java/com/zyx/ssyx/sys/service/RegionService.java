package com.zyx.ssyx.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.ssyx.model.sys.Region;

import java.util.List;


public interface RegionService extends IService<Region> {
    /**
     * 根据关键字获取地区列表
     * @param keyword
     * @return
     */
    List<Region> findRegionByKeyword(String keyword);

}
