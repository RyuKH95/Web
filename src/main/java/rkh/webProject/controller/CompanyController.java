package rkh.webProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rkh.webProject.domain.Company;
import rkh.webProject.service.CompanyService;

@Controller
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companys/new")
    public String createForm() {
        return "companys/createCompanyForm";
    }

    @PostMapping("/companys/new")
    public String companyCreate(CompanyForm form) {
        Company company = new Company();
        company.setName(form.getName());
        company.setSite(form.getSite());
        String join = companyService.join(company);
        if (join.equals("이미 존재하는 회사입니다.")) {
            return "<script>alert('이미 존재하는 회사입니다.'>; history.go(-1);</script>";//alertError();
        }
        return "redirect:/spring";
    }

    @ResponseBody
    public String alertError() {
        return "<script>alert('이미 존재하는 회사입니다.'>; history.go(-1);</script>";
    }

    @GetMapping("/companys")
    public String list(Model model) {
        List<Company> companys = companyService.findMembers();
        model.addAttribute("companys", companys);
        return "companys/companyList";
    }
}
