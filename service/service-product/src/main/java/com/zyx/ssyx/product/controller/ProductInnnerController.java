package com.zyx.ssyx.product.controller;

import com.zyx.ssyx.model.product.Category;
import com.zyx.ssyx.model.product.SkuInfo;
import com.zyx.ssyx.product.service.CategoryService;
import com.zyx.ssyx.product.service.SkuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class ProductInnnerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SkuInfoService skuInfoService;

    @ApiOperation(value = "根据分类id获取分类信息")
    @GetMapping("inner/getCategory/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return categoryService.getById(categoryId);
    }

    @ApiOperation(value = "根据skuId获取sku信息")
    @GetMapping("inner/getSkuInfo/{skuId}")
    public SkuInfo getSkuInfo(@PathVariable("skuId") Long skuId) {
        return skuInfoService.getById(skuId);
    }

}
