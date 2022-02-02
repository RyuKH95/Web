package rkh.webProject.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import rkh.webProject.domain.RUser;

public class JdbcTemplateRancityLoginRepository implements RancityRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateRancityLoginRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public RUser signIn(RUser rUser) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("RancityUser").usingGeneratedKeyColumns("num");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", rUser.getId());
        parameters.put("pw", rUser.getPw());
        parameters.put("phone", rUser.getPhone());
        parameters.put("email", rUser.getEmail());
        parameters.put("cre_ymd", LocalDate.now());
        parameters.put("use_yn", 1);
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        rUser.setNum(key.longValue());
        return rUser;
    }

    @Override
    public Optional<RUser> findByIdPw(String id, String pw) {
        return Optional.empty();
    }
}
