package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.service.ProductPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ProductPageController {
    @Autowired
    private ProductPageService productPageService;
    @GetMapping("/productPage")
    public String productPage(Model model){
        List<ProductDTO> productList = productPageService.productPage();
        model.addAttribute("productList", productList);
        return "/user/productPage";
    }
    @GetMapping("/productView")
    public String productView(int prod_code, Model model){
        ProductDTO productDTO = productPageService.productView(prod_code);
        model.addAttribute("productDTO",productDTO);
        return "/user/productView";
    }
}
