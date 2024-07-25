package gift.controller;

import gift.dto.MemberDto;
import gift.entity.Member;
import gift.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("member", new Member());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("member") MemberDto memberDto, HttpServletResponse response) {
        String token = memberService.registerMember(memberDto);
        response.setHeader("Authorization", "Bearer " + token);
        return "redirect:/members/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Map<String, String> response = new HashMap<>();
        try {
            String token = memberService.login(email, password);
            if ("admin@kakao.com".equals(email) && "admin".equals(password)) {
                session.setAttribute("user", email);
                response.put("token", token);
                response.put("role", "ADMIN");
            } else{ // 유효한 일반 사용자 검사
                session.setAttribute("user", email);
                response.put("token", token);
                response.put("role", "USER");
            }
            return response;
        } catch (RuntimeException e) {
            response.put("error", "Invalid email or password");
            return response;
        }
    }




}
