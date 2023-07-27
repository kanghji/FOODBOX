package com.groupfour.foodbox.controller;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.mapper.UserMapper;
import com.groupfour.foodbox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    // 회원가입 페이지로 이동
    @GetMapping("/userRegister")
    public String userRegister(UserDTO userDto){

        return "/user/userRegister";
    }

    // 회원가입
    @PostMapping("/userRegister")
    public String userRegisterPost(UserDTO userDto){
        int n = userService.userRegister(userDto);

        return  "redirect:/user/userList";
    }

    // 회원 리스트
    @GetMapping("/userList")
    public String userList(Model model){
        // data 만들기
        List<UserDTO> userList = userService.userList();
        model.addAttribute("userList", userList);

        return "/user/userList";
    }

    // 회원 삭제
    @RequestMapping ("/userDelete")
    public String userDelete(String user_no){
        int n = userService.userDelete(user_no);

        return "redirect:/user/userList";
    }

    // 선택삭제
    @PostMapping("/usersDelete")
    public String usersDelete(@RequestParam("chkMno") List<String> chkList) {
        System.out.println("chkList = " + chkList);

        if(chkList != null) {
            int n = userService.usersDelete(chkList);
        }
        return  "redirect:/user/userList";
    }


//    // 회원 정보
//    @GetMapping("/userInfo")
//    public String userInfo(String user_no, Model model){
//       UserDTO userDto = userService.userInfo(user_no);
//        return "/user/userInfo";
//    }






}
