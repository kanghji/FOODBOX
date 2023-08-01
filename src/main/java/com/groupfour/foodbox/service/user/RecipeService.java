package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.RecipeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RecipeService {

    List<List<RecipeDTO>> getList();
}
