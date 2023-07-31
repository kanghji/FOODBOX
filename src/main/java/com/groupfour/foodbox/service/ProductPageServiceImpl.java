package com.groupfour.foodbox.service;

import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.mapper.ProductPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPageServiceImpl implements ProductPageService{
    @Autowired
    private ProductPageMapper productPageMapper;
    //사용자페이지 상품리스트 가져오기
    @Override
    public List<ProductDTO> productPage() {
        List<ProductDTO> productList = productPageMapper.productPage();
        return productList;
    }
    //사용자페이지 상품 상세정보 가져오기
    @Override
    public ProductDTO productView(int prod_code) {
        ProductDTO productDTO = productPageMapper.productView(prod_code);
        return productDTO;
    }
}
