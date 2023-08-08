package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.mapper.user.MypageMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MypageServiceImpl implements MypageService{

    @Autowired
    MypageMapper mypageMapper;

    @Override
    public UserDTO infoUpdateChk(String user_id) {
        System.out.println("mypageMapper.infoUpdateChk(user_id) = " + mypageMapper.infoUpdateChk(user_id));
        return mypageMapper.infoUpdateChk(user_id);
    }
}
