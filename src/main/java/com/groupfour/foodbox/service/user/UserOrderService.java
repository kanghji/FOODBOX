package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.dto.UserOrderCheckDTO;

import java.util.List;

public interface UserOrderService {
    List<UserOrderCheckDTO> userOrder(String userId);

    UserDTO userOrderInfo(String userId);

    void addOrderList(List<UserOrderCheckDTO> orderList);
}
