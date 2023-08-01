package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.RecipeDTO;
import com.groupfour.foodbox.mapper.user.RecipeMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeMapper recipeMapper;

    @Override
    public List<List<RecipeDTO>> getList(){
        //DAO영속성 계층
        List<List<RecipeDTO>> list = recipeMapper.getList();

        return list;
    }
}
