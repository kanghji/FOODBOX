package com.groupfour.foodbox.service.user;


import com.groupfour.foodbox.dto.UserCartDTO;
import com.groupfour.foodbox.mapper.user.UserCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCartServiceImpl implements UserCartService {

    @Autowired
    UserCartMapper userCartMapper;

    @Override
    public void insertCart(String user_id, int prodCode, String prod_thumbnail, int prod_price, int order_qty) {
        userCartMapper.insertCart(user_id, prodCode, prod_thumbnail, prod_price, order_qty);
    }

    @Override
    public List<UserCartDTO> cartList(String user_id) {
        List<UserCartDTO> userCartList = userCartMapper.userCartList(user_id);

        return userCartList;
    }
}
