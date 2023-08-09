package com.groupfour.foodbox.service.user;


import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.dto.UserOrderCheckDTO;
import com.groupfour.foodbox.dto.UserOrderDTO;
import com.groupfour.foodbox.dto.UserOrderDetailDTO;
import com.groupfour.foodbox.mapper.user.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserOrderMapper userOrderMapper;

    @Override
    public List<UserOrderCheckDTO> userOrder(String userId) {
        List<UserOrderCheckDTO> list = userOrderMapper.userOrder(userId);

        for(UserOrderCheckDTO dto : list) {
            dto.setTotPrice(dto.getTotPrice());
        }

        return list;
    }

    @Override
    public UserDTO userOrderInfo(String userId) {

        UserDTO userDTO = userOrderMapper.userOrderInfo(userId);

        return userDTO;
    }

    @Override
    public void addOrderList(List<UserOrderCheckDTO> orderList) {
        UserOrderDTO userOrderDTO = new UserOrderDTO();

        int orderTotPrice = 0;
        for(UserOrderCheckDTO dto: orderList) {
            userOrderDTO.setUser_id(dto.getUser_id());
            userOrderDTO.setUser_name(dto.getUser_name());
            orderTotPrice += dto.getTotPrice();
        }
        userOrderDTO.setOrderTotPrice(orderTotPrice);
        userOrderMapper.insertOrderList(userOrderDTO);

        String id = userOrderDTO.getUser_id();
        String name = userOrderDTO.getUser_name();
        int generatedOrderNo = userOrderDTO.getOrder_no();

        for(UserOrderCheckDTO dto: orderList) {
            UserOrderDetailDTO userOrderDetailDTO = new UserOrderDetailDTO();
            userOrderDetailDTO.setOrder_no(generatedOrderNo);
            userOrderDetailDTO.setUser_id(id);
            userOrderDetailDTO.setUser_name(name);
            userOrderDetailDTO.setProd_code(dto.getProd_code());
            userOrderDetailDTO.setProd_name(dto.getProd_name());
            userOrderDetailDTO.setProd_thumbnail(dto.getProd_thumbnail());
            userOrderDetailDTO.setProd_price(dto.getProd_price());
            userOrderDetailDTO.setProd_qty(dto.getProd_qty());
            userOrderDetailDTO.setOrder_qty(dto.getOrder_qty());

            userOrderMapper.insertOrderDetail(userOrderDetailDTO);
        }
    }
}
