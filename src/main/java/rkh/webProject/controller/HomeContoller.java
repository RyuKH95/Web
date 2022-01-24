package rkh.webProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/colorvely")
    public String colorvely() {
        return "colorvely";
    }

    @GetMapping("/happyrancity")
    public String happyrancity() {
        return "happyrancity";
    }
}
