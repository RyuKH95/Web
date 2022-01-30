package rkh.webProject.service;


import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import rkh.webProject.domain.Company;
import rkh.webProject.repository.CompanyRepository;

//@Service //Component 스캔 방식 때 사용
@Transactional //JPA 방식 때 사용
public class CompanyService {

    private final CompanyRepository companyRepository;

    //@Autowired //Component 스캔 방식 때 사용
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * 회원가입
     *
     * @param company
     * @return getId
     */
    public Long join(Company company) {
        validateDuplicateCompany(company); //중복회원 검증
        companyRepository.save(company);

        return company.getId();
    }

    private void validateDuplicateCompany(Company company) {
        companyRepository.findByName(company.getName())
                .ifPresent(c -> {
                    throw new IllegalStateException("이미 존재하는 회사입니다.");
                });
    }

    /**
     * 전체 회원 조회
     *
     * @return
     */
    public List<Company> findMembers() {
        return companyRepository.findAll();
    }

    public Optional<Company> findOne(Long companyId) {
        return companyRepository.findById(companyId);
    }
}
