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
        return rUser;
    }

    @Override
    public Optional<RUser> findByIdPw(String id, String pw) {
        List<RUser> result = em.createQuery("select r from RancityUser r where r.id=:id and r.pw=:pw",
                RUser.class).setParameter("id", id).setParameter("pw", pw).getResultList();
        return result.stream().findAny();
    }
}
