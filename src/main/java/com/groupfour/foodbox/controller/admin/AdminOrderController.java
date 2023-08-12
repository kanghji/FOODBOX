package com.groupfour.foodbox.controller.admin;

import com.groupfour.foodbox.domain.PageDTO;
import com.groupfour.foodbox.dto.AdminOrderDTO;
import com.groupfour.foodbox.dto.AdminOrderDetailDTO;
import com.groupfour.foodbox.dto.UserOrderDetailDTO;
import com.groupfour.foodbox.service.admin.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    AdminOrderService adminOrderService;


    @GetMapping("/orderList")
    public String orderList(@RequestParam(defaultValue = "ALL") String keyword,
                            @RequestParam(defaultValue="ALL") String searchType,
                            PageDTO pageDTO, Model model) {
        List<AdminOrderDTO> orderList = adminOrderService.orderList();

        model.addAttribute("orderList", orderList);
        model.addAttribute("keyword",keyword);
        model.addAttribute("searchType",searchType);
        model.addAttribute("pageDTO", pageDTO);

        return "/admin/order/admin_orderList";
    }

    @GetMapping("/orderDetail")
    public String orderDetail(@RequestParam(defaultValue = "ALL") String keyword,
                            @RequestParam(defaultValue="ALL") String searchType,
                            PageDTO pageDTO, int order_no, Model model) {
        List<AdminOrderDetailDTO> orderDetail = adminOrderService.orderDetail(order_no);

        int orderTotprice = 0;

        for(AdminOrderDetailDTO dto: orderDetail) {
            orderTotprice += dto.getTotPrice();
        }

        model.addAttribute("orderDetail", orderDetail);
        model.addAttribute("keyword",keyword);
        model.addAttribute("searchType",searchType);
        model.addAttribute("pageDTO", pageDTO);


        return "/admin/order/admin_orderDetail";
    }

}
