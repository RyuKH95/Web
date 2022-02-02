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
        List<Company> companys = companyService.findMembers();
        model.addAttribute("companys", companys);
        return "home";
    }

    @GetMapping("colorvely")
    public String colorvely() {
        return "colorvely/colorvely";
    }

    @GetMapping("spring")
    public String spring() {
        return "spring";
    }

    @GetMapping("apitest")
    @ResponseBody
    public Hello apiTest(@RequestParam("name") String name, @RequestParam("id") String id) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setId(id);
        return hello;
    }

    static class Hello {
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
