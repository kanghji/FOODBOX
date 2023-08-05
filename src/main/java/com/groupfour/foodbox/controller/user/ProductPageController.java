package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.domain.ProductPageDTO;
import com.groupfour.foodbox.service.user.ProductPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ProductPageController {
    @Autowired
    private ProductPageService productPageService;

    @GetMapping("/productPage")
    public String productPage(@RequestParam(defaultValue = "ALL") String category_code,
                              @RequestParam(defaultValue = "ALL") String category_name,
                              @RequestParam(defaultValue = "ALL") String prod_spec,
                              @RequestParam(defaultValue = "ALL") String priceSort,
                              ProductPageDTO pageDTO,
                              Model model){
        int productCount = productPageService.productCount(category_code,prod_spec,priceSort);
        pageDTO.setValue(productCount);
        List<ProductDTO> productList = productPageService.productPage(category_code,prod_spec,priceSort,pageDTO);
        model.addAttribute("productList", productList);
        model.addAttribute("category_name",category_name);
        model.addAttribute("prod_spec",prod_spec);
        model.addAttribute("priceSort",priceSort);
        model.addAttribute("category_code",category_code);
        model.addAttribute("pageDTO",pageDTO);
        return "/user/productPage";
    }
    @GetMapping("/productPageRoad")
    @ResponseBody
    public List<ProductDTO> productPageRoad(@RequestParam(defaultValue = "ALL") String category_code,
                              @RequestParam int viewPage,
                              @RequestParam(defaultValue = "ALL") String prod_spec,
                              @RequestParam(defaultValue = "ALL") String priceSort,
                              Model model){
        ProductPageDTO pageDTO = new ProductPageDTO();
        int productCount = productPageService.productCount(category_code,prod_spec,priceSort);
        pageDTO.setValue(productCount, viewPage);
        List<ProductDTO> productList = productPageService.productPage(category_code,prod_spec,priceSort,pageDTO);
        return productList;
    }
    @GetMapping("/productView")
    public String productView(int prod_code, Model model){
        ProductDTO productDTO = productPageService.productView(prod_code);
        model.addAttribute("productDTO",productDTO);
        List<String> productImageList = productPageService.productImageList(prod_code);
        model.addAttribute("productImageList", productImageList);
        return "/user/productView";
    }
}
