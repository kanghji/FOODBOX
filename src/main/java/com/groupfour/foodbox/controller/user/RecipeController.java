package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.service.user.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/recipe")
    public String product(Model model){
        //Model 을 넘겨야 view에서 list를 띄울 수 있음.
        /*맵을 사용하여 data 만들기, 리스트를 service로 넘기기*/
        List<Map<String, Object>> list = recipeService.getList();

        model.addAttribute("list",list);


        return "/recipe/";
    }


}
