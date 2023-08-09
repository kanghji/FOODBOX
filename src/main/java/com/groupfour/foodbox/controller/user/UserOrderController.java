package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.dto.UserOrderCheckDTO;
import com.groupfour.foodbox.service.user.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserOrderController {

    @Autowired
    UserOrderService userOrderService;

    @GetMapping("/userOrder/{user_id}")
    public String userOrder(@PathVariable String user_id, Model model) {
        List<UserOrderCheckDTO> orderList = userOrderService.userOrder(user_id);
        int cartTotPrice = 0;

        for(UserOrderCheckDTO dto : orderList) {
            cartTotPrice += dto.getTotPrice();
        }

        UserDTO userDTO = userOrderService.userOrderInfo(user_id);

        model.addAttribute("orderList", orderList);
        model.addAttribute("cartTotPrice", cartTotPrice);
        model.addAttribute("userDTO", userDTO);

        return "/user/userOrderCheck";
    }

    @PostMapping("/userOrder/pay")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void userPay(@RequestBody List<UserOrderCheckDTO> orderList) {
        userOrderService.addOrderList(orderList);
    }

    @GetMapping("/userOrder/success")
    public String userOrderSuccess() {

        return "/user/userOrderSuccess";
    }
//    @GetMapping("/userOrder/orderlist")
//    public String userOrderlist() {
//
//    }
}
