package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.service.user.MypageService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MyPageController {

    @Autowired
    MypageService mypageService;

    // 비밀번호 재확인
    @GetMapping("/user_pwUpdateChk")
    public String infoUpdateChkView(HttpSession session, Model model) {
        UserDTO userDTO = (UserDTO) session.getAttribute("userLoginDto");
        model.addAttribute("userDTO", mypageService.infoUpdateChk(userDTO.getUser_id()));
//        System.out.println("DB 비밀번호 : " + mypageService.infoUpdateChk(userDTO.getUser_id()));
        return "user/user_pwUpdateChk";
    }

    // 비밀번호 재확인 후 비밀번호 변경 페이지 이동
    @PostMapping("/user_pwUpdate")
    public String pwUpdateView() {
        return "user/user_pwUpdate";
    }

    // 비밀번호 수정
    @PostMapping("/user_pwModify")
//    @RequestMapping(value="/user_pwModify", method=RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public int pwModify(@RequestBody UserDTO userDTO) {
        int new_pw = mypageService.pwModify(userDTO);
        return new_pw;
    }

    // 새 비밀번호 변경 후 페이지 이동
    @GetMapping("/user_pwUpdataChkPage")
    public String pwModifyOk() {
        return "redirect:/user/user_pwUpdateChk";
    }

    // 회원정보 수정 view
    @GetMapping("/user_infoUpdateView")
    public String infoUpdateView() {
        return "user/user_infoUpdateView";
    }

}
