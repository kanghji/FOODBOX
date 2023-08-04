package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.dto.UserCartDTO;
import com.groupfour.foodbox.service.user.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserCartController {

    @Autowired
    UserCartService userCartService;

    @PostMapping("/addCart")
    public @ResponseBody String insertCart(@RequestBody UserCartDTO userCartDTO) {

        String id = userCartDTO.getUser_id();

        UserCartDTO userCartDtoId = userCartService.checkCart(id, userCartDTO.getProd_code());

        if(userCartDtoId == null) {
            userCartService.insertCart(userCartDTO);
        } else {
            int order_qty = userCartDTO.getOrder_qty() + userCartDtoId.getOrder_qty();
            userCartService.modifyQty(order_qty, userCartDtoId.getCart_no());
        }

        return "redirect:/user/productPage";
    }

    @GetMapping("/userCartList/{id}")
    public String userCartList(String user_id, Model model) {
        List<UserCartDTO> cartList = userCartService.userCartList(user_id);

        model.addAttribute("cartList", cartList);

        return "/user/userCartList";
    }

}
