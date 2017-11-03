package com.zjiet.entry;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品实体类
 * @author: linlc
 * 2017/10/23 14:00
 */
@Entity
@Data
public class ProductInfo {

    public interface  ProductSimpleView{};
    public interface  ProductDetailView extends  ProductSimpleView{};

   @Id
   @GeneratedValue
   public String productId;

   @JsonView(ProductSimpleView.class)
   @NotBlank(message = " 商品名称不能为空！")
   public String productName;

   public BigDecimal productPrice;

   public Integer productStock;

   public String  productDescription;

   public String  productIcon;

   public String  categoryType;

   public Date  createTime;

   public Date  updateTime;

   public char  productStatus;

}
