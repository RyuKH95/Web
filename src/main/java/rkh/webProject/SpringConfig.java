package rkh.webProject;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rkh.webProject.repository.CompanyRepository;
import rkh.webProject.repository.JdbcTemplateCompanyRepository;
import rkh.webProject.repository.JdbcTemplateRancityLoginRepository;
import rkh.webProject.repository.RancityRepository;
import rkh.webProject.service.CompanyService;

@Configuration //Java 코드로 스프링 빈 등록하기
public class SpringConfig {
    //region Jdbc 방식 때 사용
    /**
     * Jdbc 방식 때 사용
     */
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    //endregion

    //region Jpa 방식 때 사용
    /**
     * Jpa 방식 때 사용
     */
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    //endregion

    @Bean //Java 코드로 스프링 빈 등록하기
    public CompanyService companyService() {
        return new CompanyService(companyRepository());
    }

    @Bean //Java 코드로 스프링 빈 등록하기
    public CompanyRepository companyRepository() {
//        return new MemoryCompanyRepository();
        return new JdbcTemplateCompanyRepository(dataSource);
//        return new JpaMemberRepository(em);
    }

//    @Bean
//    public RancityService rancityService() {
//        return new RancityService(rancityRepository());
//    }
    @Bean
    public RancityRepository rancityRepository() {
//        return new MemoryRancityLoginRepository();
        return new JdbcTemplateRancityLoginRepository(dataSource);
//        return new JpaRancityRepository(em);
    }
}
