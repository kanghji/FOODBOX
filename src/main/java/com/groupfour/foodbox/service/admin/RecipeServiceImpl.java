package com.groupfour.foodbox.service.admin;

import com.groupfour.foodbox.domain.RecipeDTO;
import com.groupfour.foodbox.mapper.user.RecipeMapper;
import com.groupfour.foodbox.service.admin.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeMapper recipeMapper;

    @Override
    public List<List<RecipeDTO>> getList(){
        //DAO영속성 계층
        List<List<RecipeDTO>> list = recipeMapper.getList();

        return list;
    }

    @Override
    public RecipeDTO recipeInfo(int id) {
        RecipeDTO recipeDTO = recipeMapper.recipeInfo(id);
        return recipeDTO;
    }
}
