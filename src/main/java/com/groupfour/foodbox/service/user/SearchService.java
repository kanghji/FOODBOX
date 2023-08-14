package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.ProductDTO;

import java.util.List;

public interface SearchService {

    List<ProductDTO> getProdSearchList(String prod_name);

}

