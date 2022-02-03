package rkh.webProject.repository;

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
        jdbcInsert.withTableName("ranuser").usingGeneratedKeyColumns("num");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", rUser.getId());
        parameters.put("password", rUser.getPassword());
        parameters.put("phone", rUser.getPhone());
        parameters.put("email", rUser.getEmail());
        parameters.put("cre_ymd", rUser.getCreate_ymd());
        parameters.put("use_yn", rUser.getUse_yn());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        rUser.setNum(key.longValue());
        return rUser;
    }

    @Override
    public Optional<RUser> findByIdPw(String id, String pw) {
        List<RUser> result = jdbcTemplate.query(
                "select * from ranuser where id = ? and password = ?", rUserRowMapper(), id, pw);
        return result.stream().findAny();
    }

    private RowMapper<RUser> rUserRowMapper() {
        return (rs, rowNum) -> {
            RUser rUser = new RUser();
//            rUser.setNum(rs.getLong("num"));
            rUser.setId(rs.getString("id"));
            rUser.setPassword(rs.getString("password"));
            return rUser;
        };
    }
}
