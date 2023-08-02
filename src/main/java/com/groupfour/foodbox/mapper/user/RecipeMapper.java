package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.domain.RecipeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecipeMapper {
     List<List<RecipeDTO>> getList();

    RecipeDTO recipeInfo(int id);

    List<List<RecipeDTO>> recipeSearch(String rcpNm);
}
