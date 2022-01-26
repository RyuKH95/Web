package rkh.webProject.repository;

import java.util.ArrayList;
import rkh.webProject.domain.Company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryCompanyRepository implements CompanyRepository{

    /**
     * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
     */
    private static Map<Long, Company> store = new HashMap<>();
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

    public void clearStore() {
        store.clear();
    }
}
