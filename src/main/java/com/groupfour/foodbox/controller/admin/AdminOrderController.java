package com.groupfour.foodbox.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {

    @GetMapping("/orderList")
    public String orderList() {
        return "admin/order/admin_orderList";
    }
}
