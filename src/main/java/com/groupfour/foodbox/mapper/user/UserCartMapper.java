package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.dto.UserCartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCartMapper {
    void insertCart(UserCartDTO userCartDTO);

    List<UserCartDTO> userCartList(String user_id);
}
