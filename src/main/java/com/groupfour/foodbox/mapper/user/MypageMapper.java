package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {

    UserDTO infoUpdateChk(String user_id);
}
