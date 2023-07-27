package com.groupfour.foodbox.controller.admin;

import com.groupfour.foodbox.domain.CategoryDTO;
import com.groupfour.foodbox.service.CategoryService;
import com.groupfour.foodbox.service.ProductService;
import com.groupfour.foodbox.util.ProductSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/productRegister")
    public String productRegister(Model model){
        List<CategoryDTO> categorylist =  categoryService.adminCategoryList();
        model.addAttribute("categorylist", categorylist);
        System.out.println("categorylist = " + categorylist);
        ProductSpec[] prodSpec = ProductSpec.values();
        model.addAttribute("prodSpec", prodSpec);
        return "/admin/product/productRegister";
    }
}
