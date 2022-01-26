package rkh.webProject.repository;

import rkh.webProject.domain.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Company save(Company company);
    Optional<Company> findById(Long id);
    Optional<Company> findByName(String name);
    List<Company> findAll();
}
