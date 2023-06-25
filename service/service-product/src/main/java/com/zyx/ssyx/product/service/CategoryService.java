package com.zyx.ssyx.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyx.ssyx.model.product.Category;
import com.zyx.ssyx.vo.product.CategoryQueryVo;

import java.util.List;

public interface CategoryService extends IService<Category> {

    /**
     * 商品分类分页列表
     * @param pageParam
     * @param categoryQueryVo
     * @return
     */
    IPage<Category> selectPage(Page<Category> pageParam, CategoryQueryVo categoryQueryVo);

    /**
     * 查询所有商品分类
     * @return
     */
    List<Category> findAllList();
}
