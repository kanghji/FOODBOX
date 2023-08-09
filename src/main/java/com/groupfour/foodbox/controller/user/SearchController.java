package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.service.user.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    // 검색
    @PostMapping("/user/prodSeach")
    @ResponseBody
    public String prodSearch(@RequestBody @RequestParam(value = "prod_name", defaultValue = "noSearch") String prod_name, Model model) {
        List<ProductDTO> getProdSearchList = searchService.getProdSearchList(prod_name);

        // 사용자가 입력한 키워드가 null이거나 빈 문자열이면
        if (getProdSearchList.isEmpty()) {
            model.addAttribute("getProdSearchList", "noSearch");
        } else {
            model.addAttribute("getProdSearchList", getProdSearchList);
        }

        return "user/userSearch";
    }




}
