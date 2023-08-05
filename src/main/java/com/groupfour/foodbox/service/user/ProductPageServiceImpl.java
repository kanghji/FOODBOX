package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.domain.ProductPageDTO;
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
    public List<ProductDTO> productPage(String category_code, String prod_spec, String priceSort, ProductPageDTO pageDTO) {
        List<ProductDTO> productList = productPageMapper.productPage(category_code,prod_spec,priceSort, pageDTO);
        return productList;
    }
    //사용자페이지 상품 상세정보 가져오기
    @Override
    public ProductDTO productView(int prod_code) {
        ProductDTO productDTO = productPageMapper.productView(prod_code);
        return productDTO;
    }
    //사용자페이지 상품 상세이미지 가져오기
    @Override
    public List<String> productImageList(int prod_code) {
        List<String> productImageList = productPageMapper.productImageList(prod_code);
        return productImageList;
    }
    //상품 개수
    @Override
    public int productCount(String categoryCode, String prodSpec, String priceSort) {
        int productCount = productPageMapper.productCount(categoryCode, prodSpec, priceSort);
        return productCount;
    }
}
