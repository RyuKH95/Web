package rkh.webProject.repository;

import java.util.ArrayList;
import rkh.webProject.domain.Company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryCompanyRepository implements CompanyRepository{

    private static Map<Long, Company> store = new HashMap<>(); //실무에서는 HashMap 을 static으로 사용하면 중복의 위험이 있어 지양
    private static long sequence = 0L;

    @Override
    public Company save(Company company) {
        company.setId(++sequence);
        store.put(company.getId(), company);
        return company;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Company> findByName(String name) {
        return store.values().stream().filter(company -> company.getName().equals(name)).findAny();
    }

    @Override
    public List<Company> findAll() {
        return new ArrayList<>(store.values());
    }
}
