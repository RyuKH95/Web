package rkh.webProject.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import rkh.webProject.domain.RUser;

public class JpaRancityRepository implements RancityRepository{

    private final EntityManager em;

    public JpaRancityRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public RUser signIn(RUser rUser) {
        em.persist(rUser);
//        em.createQuery(
//                "insert into rUser r (`id`, `password`, `phone`, `email`, `cre_ymd`, `del_ymd`, `use_yn`) values (1, 1, 1, 1, 20220202, 99991231, 1)");
        return rUser;
    }

    @Override
    public Optional<RUser> findByIdPw(String id, String password) {
        List<RUser> result = em.createQuery("select r from rUser r where r.id=:id and r.password=:password", RUser.class).setParameter("id", id).setParameter("password", password).getResultList();
        return result.stream().findAny();
//        return Optional.empty();
    }
}
