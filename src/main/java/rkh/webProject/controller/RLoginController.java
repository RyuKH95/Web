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

    @GetMapping("happyRancity")
    public String happyRancity() {
        return "happyRancity/login";
    }
    @GetMapping("happyRancity/signIn")
    public String happyRancitySignIn() {
        return "happyRancity/signIn";
    }

//    @GetMapping("happyRancity/login")
//    public String happyRancityLogin() {
//        return "happyRancity/login";
//    }
    @PostMapping("happyRancity")
    public String happyRancityLoginForm(RLoginForm form) {
        System.out.println("회원가입");
        RUser rUser = new RUser();
        rUser.setId(form.getId());
        rUser.setPassword(form.getPassword());
        rUser.setPhone(form.getPhone());
        rUser.setEmail(form.getEmail());
        rUser.setCreate_ymd(LocalDateTime.now());
        rUser.setDelete_ymd(null);
        rUser.setUse_yn(form.getUse_yn());
        rancityService.join(rUser);
        System.out.println("회원가입 데이터 "+rUser.getNum()+" "+rUser.getId()+" "+rUser.getPassword()+" "+rUser.getPhone()+" "+rUser.getEmail()+" "+rUser.getCreate_ymd()+" "+rUser.getDelete_ymd()+" "+rUser.getUse_yn());
        return "redirect:/happyRancity";
    }
}
