package rkh.webProject.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import rkh.webProject.domain.Company;

class MemoryCompanyRepositoryTest {

    MemoryCompanyRepository repository = new MemoryCompanyRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Company company = new Company();
        company.setName("spring");

        repository.save(company);
        Company result = repository.findById(company.getId()).get();
        assertThat(company).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Company company1 = new Company();
        company1.setName("spring1");
        repository.save(company1);

        Company company2 = new Company();
        company2.setName("spring2");
        repository.save(company2);

        Company result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(company1);
    }

    @Test
    public void findByAll() {
        Company company1 = new Company();
        company1.setName("spring1");
        repository.save(company1);

        Company company2 = new Company();
        company2.setName("spring2");
        repository.save(company2);

        List<Company> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
