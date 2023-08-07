package com.groupfour.foodbox.controller.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.service.user.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    // 로그인 페이지 가져오기
    @GetMapping("/userLogin")
    public String userLoginPage() {
        return "user/userLogin";
    }

    // 로그인
    @PostMapping("/userLogin")
    public String userLogin(UserDTO userDto, HttpServletRequest req, RedirectAttributes rttr) {
        boolean result = userLoginService.userLogin(userDto, req);

        System.out.println("userDto.getUser_id() = " + result);

        HttpSession session = req.getSession();
        if (!result) { // 로그인 실패
            rttr.addAttribute("result", 0);
            return "redirect:/user/userLogin"; // redirect 는 GET 방식

        }
        session.setAttribute("userLoginDto", userDto);

        return "redirect:/";
    }

    // 로그아웃
    @GetMapping("/userLogout")
    public String userLogout(HttpSession session) {
        session.invalidate(); // 세션 초기화
        return "redirect:/";
    }

}



