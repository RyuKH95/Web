package rkh.webProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rkh.webProject.repository.CompanyRepository;
import rkh.webProject.repository.MemoryCompanyRepository;
import rkh.webProject.service.CompanyService;

@Configuration //Java 코드로 스프링 빈 등록하기
public class SpringConfig {

    @Bean //Java 코드로 스프링 빈 등록하기
    public CompanyService companyService() {
        return new CompanyService(companyRepository());
    }

    @Bean //Java 코드로 스프링 빈 등록하기
    public CompanyRepository companyRepository() {
        return new MemoryCompanyRepository();
    }
}
