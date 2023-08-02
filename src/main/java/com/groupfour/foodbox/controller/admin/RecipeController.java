package com.groupfour.foodbox.controller.admin;

import com.groupfour.foodbox.domain.RecipeDTO;
import com.groupfour.foodbox.service.admin.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    //레시피 리스트 페이지 연결
    @GetMapping("/recipe")
    public String recipeList(Model model){
        //Model 을 넘겨야 view에서 list를 띄울 수 있음.
        /*맵을 사용하여 data 만들기, 리스트를 service로 넘기기*/
        List<List<RecipeDTO>> list = recipeService.getList();

        model.addAttribute("list",list);

        //System.out.println("list = " + list);
        return "/admin/recipe/recipeList";
    }
    //레시피 수정 클릭시 상세 보기 페이지 이동
    @GetMapping("/recipeInfo/{id}")
    public String recipeInfo(@PathVariable int id, Model model){
        RecipeDTO recipeDTO = recipeService.recipeInfo(id);
        model.addAttribute("recipeDTO", recipeDTO);

        return "/admin/recipe/recipeInfo";
    }



}
