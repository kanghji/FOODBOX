package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.UserDTO;
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
public class MyPageController {

    // 사용자페이지 - 비밀번호 재확인 view (임시)
    @GetMapping("/user_infoUpdateChk")
    public String infoUpdateChk() {
        return "user/user_infoUpdateChk";
    }

    // 사용자페이지 - 비밀번호 변경 view (임시)
    @GetMapping("/user_pwUpdate")
    public String pwUpdate() {
        return "user/user_pwUpdate";
    }

    // 사용자페이지 - 회원수정정보 view
    @GetMapping("/user_infoUpdateView")
    public String infoUpdateView() {
        return "user/user_infoUpdateView";
    }

}
