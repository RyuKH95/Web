package rkh.webProject.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import rkh.webProject.domain.Company;

public class JdbcTemplateCompanyRepository implements CompanyRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired //생략가능
    public JdbcTemplateCompanyRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Company save(Company company) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("company").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", company.getName());
        parameters.put("site", company.getSite());
        parameters.put("CRE_YMD", LocalDate.now());
        parameters.put("CHG_YMD", LocalDate.now());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        company.setId(key.longValue());
        return company;
    }

    @Override
    public Optional<Company> findById(Long id) {
        List<Company> result = jdbcTemplate.query("select * from company where id = ?", companyRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Company> findByName(String name) {
        List<Company> result = jdbcTemplate.query("select * from company where name = ?", companyRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<Company> findAll() {
        return jdbcTemplate.query("select * from company", companyRowMapper());
    }

    private RowMapper<Company> companyRowMapper() {
        return (rs, rowNum) -> {
            Company company = new Company();
            company.setId(rs.getLong("id"));
            company.setName(rs.getString("name"));
            return company;
        };
    }
}
