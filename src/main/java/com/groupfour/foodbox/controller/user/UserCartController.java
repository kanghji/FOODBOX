package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.dto.UserCartDTO;
import com.groupfour.foodbox.service.user.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserCartController {

    @Autowired
    UserCartService userCartService;

    @GetMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("user_id", "test");

        return "redirect:/";
    }

    @PostMapping("/addCart")
    public @ResponseBody String insertCart(@RequestBody UserCartDTO userCartDTO) {

        userCartService.insertCart(userCartDTO);

        return "redirect:/user/productPage";
    }

    @GetMapping("/userCartList")
    public String userCartList(String user_id) {
        List<UserCartDTO> cartList = userCartService.cartList(user_id);

        return "/user/userCartList";
    }

}
