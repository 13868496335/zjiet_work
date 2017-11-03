package com.zjiet.service.productService;

import com.zjiet.entry.ProductInfo;

import java.util.List;

/**
 * @author: linlc
 * 2017/10/23 14:15
 */
public interface ProductInfoService {

    /*
    根据  库存查询  商品列表
    【ProductStock】
    */
    public List<ProductInfo> findByProductStock(Integer productStock);

    public List<ProductInfo> findAll();

    public ProductInfo   findOne(String productId);
}
