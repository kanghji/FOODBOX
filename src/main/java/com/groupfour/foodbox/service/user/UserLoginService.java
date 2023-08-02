package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.UserDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface UserLoginService {

    boolean userLogin(UserDTO userDto, HttpServletRequest req);
}
