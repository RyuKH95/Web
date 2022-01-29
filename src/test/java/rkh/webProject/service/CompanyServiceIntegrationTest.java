package rkh.webProject.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import rkh.webProject.domain.Company;
import rkh.webProject.repository.CompanyRepository;

@SpringBootTest
@Transactional
class CompanyServiceIntegrationTest {

    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyRepository CompanyRepository;

    @Test
    void join회원가입() {
        //given
        Company company = new Company();
        company.setName("spring");
        company.setSite("a@a.a");
        company.setAddress("대전 대덕구 송촌남로18");
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
        company1.setSite("a@a.a");
        company1.setAddress("대전 대덕구 송촌남로18");

        Company company2 = new Company();
        company2.setName("spring");
        company2.setSite("a@a.a");
        company2.setAddress("대전 대덕구 송촌남로18");
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