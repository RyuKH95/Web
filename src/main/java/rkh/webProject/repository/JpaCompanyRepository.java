package rkh.webProject.repository;

import rkh.webProject.model.Company;

import java.util.List;
import java.util.Optional;

public class JpaCompanyRepository implements CompanyRepository{

    @Override
    public Company save(Company company) {
        return null;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Company> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Company> findAll() {
        return null;
    }
//    private final EntityManager em;
//
//    public JpaCompanyRepository(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    public Company save(Company company) {
//        em.persist(company);
//        return company;
//    }
//
//    @Override
//    public Optional<Company> findById(Long id) {
//        Company company = em.find(Company.class, id);
//        return Optional.ofNullable(company);
//    }
//
//    @Override
//    public Optional<Company> findByName(String name) {
//        List<Company> result = em.createQuery("select c from Company c where c.name=:name",  Company.class).setParameter("name", name).getResultList();
//        System.out.println(result);
//        return result.stream().findAny();
//    }
//
//    @Override
//    public List<Company> findAll() {
//        return em.createQuery("select c from Company m", Company.class).getResultList();
//    }
}
