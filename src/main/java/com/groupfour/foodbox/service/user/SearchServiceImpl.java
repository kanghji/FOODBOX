package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.mapper.user.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Override
    public List<ProductDTO> getProdSearchList(String prod_name) {
        List<ProductDTO> SearchList = searchMapper.getSearchList(prod_name);
        return SearchList;
    }

}

