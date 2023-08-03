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
    public void insertCart(UserCartDTO userCartDTO) {
        userCartMapper.insertCart(userCartDTO);
    }

    @Override
    public List<UserCartDTO> cartList(String user_id) {
        List<UserCartDTO> userCartList = userCartMapper.userCartList(user_id);

        return userCartList;
    }
}
