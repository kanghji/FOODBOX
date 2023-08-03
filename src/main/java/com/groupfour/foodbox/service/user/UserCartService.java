package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.dto.UserCartDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserCartService {

    void insertCart(UserCartDTO userCartDTO);


    List<UserCartDTO> cartList(String user_id);
}
