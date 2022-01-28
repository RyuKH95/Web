package rkh.webProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/company/new")
    public String createForm() {
        return "company/createCompanyForm";
    }
    @PostMapping("/company/new")
    public String companyCreate(CompanyForm form) {
        Company company = new Company();
        company.setName(form.getName());

        companyService.join(company);
        return "redirect:/spring";
    }
}
