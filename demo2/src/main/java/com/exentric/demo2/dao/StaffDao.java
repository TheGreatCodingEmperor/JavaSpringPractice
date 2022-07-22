package com.exentric.demo2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.exentric.demo2.dto.Staff;

@Component
public class StaffDao implements IStaffDao {
    // @Autowired
    // NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Qualifier("demo1JdbcTemplate")
    private NamedParameterJdbcTemplate demo1JdbcTemplate;

    // @Autowired
    // @Qualifier("demo2JdbcTemplate")
    // private NamedParameterJdbcTemplate demo2JdbcTemplate;

    @Override
    public Staff create(Staff staff) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Staff findById(Integer id) {
        String sql = "select Id,Name,Account from staff where id = :id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        // HashMap<String,Object> map = new HashMap<>();
        // map.put("id",id);

        // List<Staff> result = namedParameterJdbcTemplate.query(sql,
        // mapSqlParameterSource,new StaffRowMapper());
        List<Staff> result = demo1JdbcTemplate.query(sql, mapSqlParameterSource,
                new BeanPropertyRowMapper<>(Staff.class));
        if (result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

}
