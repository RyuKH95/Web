package rkh.webProject.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import rkh.webProject.domain.Company;

public class JpaMemberRepository implements CompanyRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Company save(Company company) {
        em.persist(company);
        return company;
    }

    @Override
    public Optional<Company> findById(Long id) {
        Company company = em.find(Company.class, id);
        return Optional.ofNullable(company);
    }

    @Override
    public Optional<Company> findByName(String name) {
        List<Company> result = em.createQuery("select c from Company c where c.name=:name",
                Company.class).setParameter("name", name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Company> findAll() {
        List<Company> result = em.createQuery("select c from Company c",
                Company.class).getResultList();
        return result;
    }
}
