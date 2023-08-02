package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.dto.UserCartDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserCartService {

    void insertCart(String user_id, int prod_code, String prod_thumbnail, int prod_price, int order_qty);


    List<UserCartDTO> cartList(String user_id);
}
