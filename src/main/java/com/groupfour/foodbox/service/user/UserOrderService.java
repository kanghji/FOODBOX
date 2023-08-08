package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.dto.UserOrderDTO;

import java.util.List;

public interface UserOrderService {
    List<UserOrderDTO> userOrder(String userId);

    UserDTO userOrderInfo(String userId);
}
