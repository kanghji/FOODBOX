package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.dto.UserOrderCheckDTO;
import com.groupfour.foodbox.dto.UserOrderDTO;
import com.groupfour.foodbox.dto.UserOrderDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserOrderMapper {
    List<UserOrderCheckDTO> userOrder(String userId);

    UserDTO userOrderInfo(String userId);

    void insertOrderList(UserOrderDTO userOrderDTO);

    void insertOrderDetail(UserOrderDetailDTO userOrderDetailDTO);

    List<UserOrderDTO> getUserOrderList(String id);

    List<UserOrderDetailDTO> getUserOrderDetail(int order_no);

    void userOrderDelete(int orderNo);

    void userOrderListDelete(int orderNo);
}
