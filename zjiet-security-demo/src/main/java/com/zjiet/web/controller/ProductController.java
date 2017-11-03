package com.zjiet.web.controller;
import com.zjiet.VO.ResultVO;
import com.zjiet.entry.ProductInfo;
import com.zjiet.service.productService.ProductInfoService;
import com.zjiet.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


/**
 * @author: linlc
 * 2017/10/23 14:21
 */


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductInfoService productInfoService;

    /**
     * 通过库存  ， 查询商品
     * @param
     * @return
     */
    @GetMapping("/findByStock/{id:\\d+}")
    public ResultVO findByProductInfoStock(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response){
        List<ProductInfo> productInfos = productInfoService.findByProductStock(id);
        System.out.println("查询成功！！");
        return ResultVOUtil.SUCCESS(productInfos);
    }


    /**
     * 通过 商品id，查询商品 。
     * @param productInfo
     * @param results
     * @return
     */
    @PostMapping("/findOne")
    //@JsonView(ProductInfo.ProductDetailView.class)
    public ResultVO findByProductInfoStock(@Valid ProductInfo productInfo , BindingResult results){
       //打印错误信息
       if(results.hasErrors()){
           results.getAllErrors().stream().forEach(
                   error ->  {
                     //  FieldError fieldError = (FieldError)error;
                       System.out.println(error.getDefaultMessage());
                   }
           );
       }

       productInfo = productInfoService.findOne(productInfo.getProductId());
       return ResultVOUtil.SUCCESS(productInfo);
    }



}
