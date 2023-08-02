package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.dto.UserCartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCartMapper {
    void insertCart(String user_id, int prodCode, String prod_thumbnail, int prod_price, int order_qty);

    List<UserCartDTO> userCartList(String user_id);
}
