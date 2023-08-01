package com.groupfour.foodbox.controller.admin;

import com.groupfour.foodbox.domain.RecipeDTO;
import com.groupfour.foodbox.service.user.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipe")
    public String recipeList(Model model){
        //Model 을 넘겨야 view에서 list를 띄울 수 있음.
        /*맵을 사용하여 data 만들기, 리스트를 service로 넘기기*/
        List<List<RecipeDTO>> list = recipeService.getList();

        model.addAttribute("list",list);

        //System.out.println("list = " + list);
        return "/admin/recipe/recipeList";
    }


}
