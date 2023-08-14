package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.service.user.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class SearchController {

    @Autowired
    private SearchService searchService;

    // 검색 페이지 이동
    @GetMapping("/search")
    public String searchPage(Model model, String prod_name) {
        List<ProductDTO> prodSearchList = searchService.getProdSearchList(prod_name);
        model.addAttribute("prodSearchList", prodSearchList);
        return "user/userSearch";
    }


    // 상품 검색
    @PostMapping("/prodSearch")
    @ResponseBody
    public List<ProductDTO> prodSearch(@RequestBody @RequestParam(value = "prod_name", defaultValue = "noSearch") String prod_name) {
        List<ProductDTO> getProdSearchList = searchService.getProdSearchList(prod_name);
        System.out.println("getProdSearchList = " + getProdSearchList);

        if (prod_name.trim().isEmpty()) {

        }


        return getProdSearchList;
    }

    // 레시피 검색
}
