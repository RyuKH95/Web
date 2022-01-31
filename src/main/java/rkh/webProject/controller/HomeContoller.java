package rkh.webProject.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import rkh.webProject.domain.Company;
import rkh.webProject.service.CompanyService;

@Controller
public class HomeContoller {

    private CompanyService companyService;

    public HomeContoller(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", "colorvely");
        List<Company> companys = companyService.findMembers();
        model.addAttribute("companys", companys);
        return "home";
    }

    @GetMapping("/colorvely")
    public String colorvely() {
        return "colorvely";
    }

    @GetMapping("/spring")
    public String spring() {
        return "spring";
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
