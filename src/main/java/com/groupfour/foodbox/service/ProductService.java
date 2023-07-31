package com.groupfour.foodbox.service;

import com.groupfour.foodbox.domain.CategoryDTO;
import com.groupfour.foodbox.domain.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface ProductService {
    //상품등록
    void adminProductRegister(MultipartHttpServletRequest mr, HttpServletRequest request);
    //상품리스트
    List<ProductDTO> productList();
    //상품 정보페이지
    ProductDTO productInfo(int prod_code);
    //상품상세이미지리스트 조회
    List<String> productImageList(int prod_code);
}
