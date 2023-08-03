package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.CategoryDTO;
import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.service.user.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserRegisterController {
    @Autowired
    private UserRegisterService userRegisterService;

    // 회원가입 페이지로 이동
    @GetMapping("/userRegister")
    public String userRegister(UserDTO userDto) {

        return "/user/userRegister";
    }

    // 회원가입
    @PostMapping("/userRegister")
    public String userRegisterPost(UserDTO userDto) {
        int n = userRegisterService.userRegister(userDto);

        return "redirect:/user/userLogin";
    }

    // 아이디 중복체크
    @GetMapping("/checkUser_id")
    @ResponseBody
    public String checkUser_id(String user_id){

        //db에 회원이 입력한 user_id가 있는지 조회
        UserDTO userDto= userRegisterService.checkUser_id(user_id);
        if(userDto !=null || "".equals(user_id.trim())){
            return "no";
        }
        return "yes";
    }



}