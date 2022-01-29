package rkh.webProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        companyService.join(company);
        return "redirect:/spring";
    }

    @GetMapping("/companys")
    public String list(Model model) {
        List<Company> companys = companyService.findMembers();
        model.addAttribute("companys", companys);
        return "companys/companyList";
    }
}
