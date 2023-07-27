package com.groupfour.foodbox.service;

import com.groupfour.foodbox.domain.CategoryDTO;
import com.groupfour.foodbox.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;

}
