package rkh.webProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeContoller {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", "colorvely");
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

    @GetMapping("/apitest")
    @ResponseBody
    public Hello apiTest(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
