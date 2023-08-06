package com.groupfour.foodbox.service.user;


import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.dto.UserOrderDTO;
import com.groupfour.foodbox.mapper.user.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserOrderMapper userOrderMapper;

    @Override
    public List<UserOrderDTO> userOrder(String userId) {
        List<UserOrderDTO> list = userOrderMapper.userOrder(userId);

        for(UserOrderDTO dto : list) {
            dto.setTotPrice(dto.getTotPrice());
        }

        return list;
    }

    @Override
    public UserDTO userOrderInfo(String userId) {

        UserDTO userDTO = userOrderMapper.userOrderInfo(userId);

        return userDTO;
    }
}
