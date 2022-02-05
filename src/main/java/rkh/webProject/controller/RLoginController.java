package rkh.webProject.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import rkh.webProject.domain.RUser;
import rkh.webProject.service.RancityService;

@Controller
public class RLoginController {

    private final RancityService rancityService;

    @Autowired
    public RLoginController(RancityService rancityService) {
        this.rancityService = rancityService;
    }

    //메인로그인화면
    @GetMapping("happyRancity")
    public String happyRancity() {
        return "happyRancity/login";
    }

    //로그인
    @PostMapping("happyRancity")
    public String happyRancityLogin(RLoginForm form) {
        RUser rUser = new RUser();
        rUser.setId(form.getId());
        rUser.setPassword(form.getPassword());
        if(rancityService.login(rUser)) {
            return "happyRancity/happyRancity";
        }
        else {
            return "happyRancity/login";
        }
    }

    //회원가입
    @GetMapping("happyRancity/signIn")
    public String happyRancitySignIn() {
        return "happyRancity/signIn";
    }
    //회원가입
    @PostMapping("happyRancity/signIn")
    public String happyRancityLoginForm(RLoginForm form) {
        RUser rUser = new RUser();
        rUser.setId(form.getId());
        rUser.setPassword(form.getPassword());
        rUser.setPhone(form.getPhone());
        rUser.setEmail(form.getEmail());
        rUser.setCreate_ymd(LocalDateTime.now());
        rUser.setDelete_ymd(null);
        rUser.setUse_yn(form.getUse_yn());
        rancityService.join(rUser);
        return "redirect:/happyRancity";
    }
}
