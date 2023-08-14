package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.dto.UserOrderCheckDTO;
import com.groupfour.foodbox.dto.UserOrderDTO;
import com.groupfour.foodbox.dto.UserOrderDetailDTO;
import com.groupfour.foodbox.service.user.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void userPay(@RequestBody UserOrderCheckDTO userOrderCheckDTO) {
        userOrderService.addOrderList(userOrderCheckDTO);
    }

    @GetMapping("/userOrder/success")
    public String userOrderSuccess() {

        return "/user/userOrderSuccess";
    }

    @GetMapping("/userOrder/orderlist")
    public String userOrderlist(HttpSession session, Model model) {
        UserDTO userDTO = (UserDTO) session.getAttribute("userLoginDto");
        String id = userDTO.getUser_id();

        List<UserOrderDTO> orderList = userOrderService.getUserOrderList(id);
        model.addAttribute("orderList", orderList);
        return "/user/userOrderList";
    }

    @GetMapping("/userOrder/orderdetail")
    public String userOrderDetail(int order_no, Model model) {
        List<UserOrderDetailDTO> orderDetail = userOrderService.getUserOrderDetail(order_no);
        int orderTotprice = 0;

        for(UserOrderDetailDTO dto: orderDetail) {
            orderTotprice += dto.getTotPrice();
        }

        model.addAttribute("orderDetail", orderDetail);
        model.addAttribute("orderTotprice", orderTotprice);

        return "/user/userOrderDetail";
    }

    @PostMapping("/userOrder/delete")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void userOrderDelete(@RequestBody String order_no) {
        int userNo = Integer.parseInt(order_no);
        List<UserOrderDetailDTO> orderDetail = userOrderService.getUserOrderDetail(userNo);
        userOrderService.userOrderDelete(userNo, orderDetail);
    }
}
