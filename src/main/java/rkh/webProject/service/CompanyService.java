package rkh.webProject.service;


import rkh.webProject.model.Company;
import rkh.webProject.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

public class CompanyService {
    private final CompanyRepository memberRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.memberRepository = companyRepository;
    }

    /**
     * 회원가입
     *
     * @param company
     * @return getId
     */
    public Long join(Company company) {
        validateDuplicateMember(company); //중복회원 검증
        memberRepository.save(company);
        return company.getId();
    }

    private void validateDuplicateMember(Company company) {
        memberRepository.findByName(company.getName()).ifPresent(member1 -> {
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
