package com.groupfour.foodbox.controller;

import com.groupfour.foodbox.domain.CategoryDTO;
import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.service.admin.CategoryService;
import com.groupfour.foodbox.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;


    // 메인 페이지
    @RequestMapping("/")
    public String root() {

        return "home/user_home";
    }

    // navigation 카테고리 메뉴 불러오기
    @GetMapping("/categoryCodeList")
    @ResponseBody
    public List<CategoryDTO> categoryCodeList(Model model) {
        List<CategoryDTO> categoryList = categoryService.adminCategoryList();
        model.addAttribute("categoryList", categoryList);
//        return "user_inc/header";
        return categoryList;
    }
}
