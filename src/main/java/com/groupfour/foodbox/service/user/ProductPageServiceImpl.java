package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.mapper.user.ProductPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPageServiceImpl implements ProductPageService{
    @Autowired
    private ProductPageMapper productPageMapper;
    //사용자페이지 상품리스트 가져오기
    @Override
    public List<ProductDTO> productPage(String category_code) {
        List<ProductDTO> productList = productPageMapper.productPage(category_code);
        return productList;
    }
    //사용자페이지 상품 상세정보 가져오기
    @Override
    public ProductDTO productView(int prod_code) {
        ProductDTO productDTO = productPageMapper.productView(prod_code);
        return productDTO;
    }

    @Override
    public List<String> productImageList(int prod_code) {
        List<String> productImageList = productPageMapper.productImageList(prod_code);
        return productImageList;
    }
}
