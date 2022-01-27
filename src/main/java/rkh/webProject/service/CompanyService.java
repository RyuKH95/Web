package rkh.webProject.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rkh.webProject.domain.Company;
import rkh.webProject.repository.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository memberRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.memberRepository = companyRepository;
    }

//    private final CompanyRepository memberRepository = new MemoryCompanyRepository();

    /**
     * 회원가입
     *
     * @param company
     * @return getId
     */
    public Long join(Company company) {
        validateDuplicateCompany(company); //중복회원 검증
        memberRepository.save(company);
        return company.getId();
    }

    private void validateDuplicateCompany(Company company) {
        memberRepository.findByName(company.getName())
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
        return memberRepository.findAll();
    }

    public Optional<Company> findOne(Long companyId) {
        return memberRepository.findById(companyId);
    }
}
