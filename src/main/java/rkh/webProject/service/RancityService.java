package rkh.webProject.service;

import java.util.NoSuchElementException;
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

    /**
     * 로그인
     */
    public Boolean login(RUser rUser) {
        try {
            if (rancityRepository.findByIdPw(rUser.getId(), rUser.getPassword()).isPresent())
                return true;
            else {
                throw new NoSuchElementException(); //로그인정보 없음
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
