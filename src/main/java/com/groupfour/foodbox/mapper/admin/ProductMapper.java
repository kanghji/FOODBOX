package com.groupfour.foodbox.mapper.admin;

import com.groupfour.foodbox.domain.CategoryDTO;
import com.groupfour.foodbox.domain.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    //상품 등록
    void adminProductRegister(Map map);
    //상품상세이미지 등록
    void adminProductImageRegister(String image_prod_image);
    //상품목록
    List<ProductDTO> productList();
    //상품 정보페이지
    ProductDTO productInfo(int prod_code);
    //상품 상세정보 이미지
    List<String> productImageList(int prod_code);
}
