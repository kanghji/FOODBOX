package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.*;
import com.groupfour.foodbox.service.user.RecipePageService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("/user")
public class RecipePageController {
    @Autowired
    private RecipePageService recipePageService;
    //사용자페이지 레시피 리스트
    @GetMapping("/recipe")
    public String recipe(ProductPageDTO pageDTO, Model model){
        int recipeCount = recipePageService.recipeCount();
        pageDTO.setValue(recipeCount);
        model.addAttribute("pageDTO", pageDTO);
        List<RecipeDTO> recipeList = recipePageService.recipeList(pageDTO);
        model.addAttribute("recipeList", recipeList);
        return "/user/recipePage";
    }
    @GetMapping("/recipePageRoad/{viewPage}")
    @ResponseBody
    public List<RecipeDTO> productPageRoad(@PathVariable("viewPage") int viewPage){
        ProductPageDTO pageDTO = new ProductPageDTO();
        int recipeCount = recipePageService.recipeCount();
        pageDTO.setValue(recipeCount,viewPage);
        List<RecipeDTO> recipeList = recipePageService.recipeList(pageDTO);
        return recipeList;
    }
    @GetMapping("/recipeView")
    public String recipeView(Long id, Model model){
        RecipeDTO recipeDTO = recipePageService.recipeView(id);
        model.addAttribute("recipeDTO", recipeDTO);
        return "/user/recipeView";
    }
    @PostMapping("/bookmarkRegister/{user_id}")
    @ResponseBody
    public String bookmarkRegister(@RequestBody BookmarkDTO bookmarkDTO,
                                   @PathVariable("user_id") String user_id){
        UserDTO userDTO = recipePageService.userCheck(user_id);
        bookmarkDTO.setBm_user_no(userDTO.getUser_no());
        BookmarkDTO dbBookmark = recipePageService.bookmarkCheck(bookmarkDTO);
        if(dbBookmark==null) {
            int n = recipePageService.bookmarkRegister(bookmarkDTO);
            return "register";
        }else if(dbBookmark!=null){
            return "have";
        }
        return "fail";
    }
}
