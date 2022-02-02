package rkh.webProject.repository;

import java.util.Optional;
import rkh.webProject.domain.RUser;

public interface RancityRepository {
    RUser signIn(RUser rUser);
    Optional<RUser> findByIdPw(String id, String pw);
}
