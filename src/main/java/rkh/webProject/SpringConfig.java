package rkh.webProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import rkh.webProject.repository.CompanyRepository;
import rkh.webProject.service.CompanyService;

//@Configuration
public class SpringConfig {

    //region JPAEntityManager
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    //endregion

    private final CompanyRepository companyRepository;

    @Autowired
    public SpringConfig(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Bean
    public CompanyService companyService() {
//        return new CompanyService(companyService());
        return new CompanyService(companyRepository);
    }

//    @Bean
//    public CompanyService companyService() {
////        return new MemoryCompanyRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaCompanyRepository(em);
//    }

}
