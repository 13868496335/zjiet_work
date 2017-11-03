package com.zjiet.service.imp;

import com.zjiet.entry.ProductInfo;
import com.zjiet.repository.ProductInfoRepository;
import com.zjiet.service.productService.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: linlc
 * 2017/10/23 14:18
 */

@Service
public class ProductInfoServiceImp implements ProductInfoService {

    @Autowired
    ProductInfoRepository repository;

    @Override
    public List<ProductInfo> findByProductStock(Integer productStock) {
        List<ProductInfo> productInfos = repository.findByProductStock(productStock);
        return productInfos;
    }

    @Override
    public List<ProductInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }
}
