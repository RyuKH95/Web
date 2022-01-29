package rkh.webProject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rkh.webProject.domain.Company;
import rkh.webProject.repository.MemoryCompanyRepository;

class CompanyServiceTest {

    CompanyService companyService; //= new CompanyService();
    MemoryCompanyRepository memoryCompanyRepository; //= new MemoryCompanyRepository();

    @BeforeEach
    public void beforeEach() {
        memoryCompanyRepository = new MemoryCompanyRepository();
        companyService = new CompanyService(memoryCompanyRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryCompanyRepository.clearStore();
    }

    @Test
    void join회원가입() {
        //given
        Company company = new Company();
        company.setName("spring");

        //when
        String saveId = companyService.join(company);

        //then
        Company findCompany = companyService.findOne(Long.parseLong(saveId)).get();
        assertThat(company.getName()).isEqualTo(findCompany.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Company company1 = new Company();
        company1.setName("spring");

        Company company2 = new Company();
        company2.setName("spring");
        //when
        companyService.join(company1);
        /*
        try {
            companyService.join(company2);
            fail();
        } catch (IllegalStateException e) {
            System.out.println("예외발생정상 : " + e);
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회사입니다.");
        }
        */
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> companyService.join(company2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회사입니다.");
        //then

    }

    @Test
    void findMembers전체조회() {
    }

    @Test
    void findOne회사조회() {
    }
}