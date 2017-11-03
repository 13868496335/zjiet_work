package com.zjiet.repository;

import com.zjiet.entry.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品__JPA
 * @author: linlc
 * 2017/10/23 14:11
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
      public    List<ProductInfo>  findByProductStock (Integer productStock);
 }
