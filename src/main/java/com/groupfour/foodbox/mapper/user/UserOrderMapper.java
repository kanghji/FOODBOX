package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.dto.UserOrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserOrderMapper {
    List<UserOrderDTO> userOrder(String userId);

    UserDTO userOrderInfo(String userId);
}
