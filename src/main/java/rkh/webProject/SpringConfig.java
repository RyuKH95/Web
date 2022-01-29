package rkh.webProject;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rkh.webProject.repository.CompanyRepository;
import rkh.webProject.repository.JdbcTemplateCompanyRepository;
import rkh.webProject.service.CompanyService;

@Configuration //Java 코드로 스프링 빈 등록하기
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean //Java 코드로 스프링 빈 등록하기
    public CompanyService companyService() {
        return new CompanyService(companyRepository());
    }

    @Bean //Java 코드로 스프링 빈 등록하기
    public CompanyRepository companyRepository() {
//        return new MemoryCompanyRepository();
        return new JdbcTemplateCompanyRepository(dataSource);
    }
}
