package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.dto.UserOrderDTO;
import com.groupfour.foodbox.service.user.UserOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserOrderController {

    @Autowired
    UserOrderService userOrderService;

    @GetMapping("/userOrder/{user_id}")
    public String userOrder(@PathVariable String user_id, Model model) {
        List<UserOrderDTO> orderList = userOrderService.userOrder(user_id);
        int cartTotPrice = 0;

        for(UserOrderDTO dto : orderList) {
            cartTotPrice += dto.getTotPrice();
        }

        UserDTO userDTO = userOrderService.userOrderInfo(user_id);

        model.addAttribute("orderList", orderList);
        model.addAttribute("cartTotPrice", cartTotPrice);
        model.addAttribute("userDTO", userDTO);

        return "/user/userOrderCheck";
    }

}
