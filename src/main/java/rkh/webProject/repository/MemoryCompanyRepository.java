package rkh.webProject.repository;

import rkh.webProject.model.Company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryCompanyRepository implements CompanyRepository{

    private static Map<Long, Company> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Company save(Company company) {
        company.setId(++sequence);

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
}
