package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.domain.ProductPageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductPageService {
    //사용자페이지 상품 리스트 가져오기
    List<ProductDTO> productPage(String category_code, String prod_spec, String priceSort, ProductPageDTO pageDTO);
    //사용자페이지 상품상세정보 가져오기
    ProductDTO productView(int prod_code);
    //사용자페이지 상품상세이미지 가져오기
    List<String> productImageList(int prod_code);
    //상품개수
    int productCount(String categoryCode, String prodSpec, String priceSort);
}
