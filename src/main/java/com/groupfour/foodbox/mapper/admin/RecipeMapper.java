package com.groupfour.foodbox.mapper.admin;

import com.groupfour.foodbox.domain.PageDTO;
import com.groupfour.foodbox.domain.RecipeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecipeMapper {
     List<List<RecipeDTO>> getList(PageDTO pageDTO);

    int totalCnt(PageDTO pageDTO);

    RecipeDTO recipeInfo(int id);

    List<List<RecipeDTO>> recipeSearch(String rcpNm, PageDTO pageDTO);

    int searchCnt(String RCP_NM);
}
