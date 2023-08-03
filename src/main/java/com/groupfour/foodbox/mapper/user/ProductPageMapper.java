package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.domain.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductPageMapper {
    //사용자페이지 상품리스트 가져오기
    List<ProductDTO> productPage(String category_code);
    //사용자페이지 상품상세정보 가져오기
    ProductDTO productView(int prod_code);
    //사용자페이지 상품상세이미지 가져오기
    List<String> productImageList(int prod_code);
}
