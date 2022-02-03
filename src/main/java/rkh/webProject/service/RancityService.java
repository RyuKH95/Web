package rkh.webProject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rkh.webProject.domain.RUser;
import rkh.webProject.repository.RancityRepository;

@Service
@Transactional
public class RancityService {

    private final RancityRepository rancityRepository;

    public RancityService(RancityRepository rancityRepository) {
        this.rancityRepository = rancityRepository;
    }

    /**
     * 회원가입
     * @param rUser
     * @return
     */
    public String join(RUser rUser) {
        validateDuplicateCompany(rUser); //중복회원 검증
        rancityRepository.signIn(rUser);

        return rUser.getId();
    }

    private void validateDuplicateCompany(RUser rUser) {
        rancityRepository.findByIdPw(rUser.getId(), rUser.getPassword())
                .ifPresent(c -> {
                    throw new IllegalStateException("이미 존재하는 ID입니다.");
                });
    }
}
