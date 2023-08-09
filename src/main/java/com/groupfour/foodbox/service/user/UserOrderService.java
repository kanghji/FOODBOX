package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.dto.UserOrderCheckDTO;
import com.groupfour.foodbox.dto.UserOrderDetailDTO;

import java.util.List;

public interface UserOrderService {
    List<UserOrderCheckDTO> userOrder(String userId);

    UserDTO userOrderInfo(String userId);

    void addOrderList(List<UserOrderCheckDTO> orderList);

    List<UserOrderDetailDTO> getUserOrderList(String id);
}
