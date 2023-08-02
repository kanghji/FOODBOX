package com.groupfour.foodbox.service.admin;

import com.groupfour.foodbox.domain.RecipeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RecipeService {

    List<List<RecipeDTO>> getList();

    RecipeDTO recipeInfo(int id);
}
