package com.exentric.demo2.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exentric.demo2.dto.Staff;
import com.exentric.demo2.service.StaffService;

@RestController
public class StaffController {
    // @Autowired
    // @Qualifier("demo1JdbcTemplate")
    // NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    @Qualifier("demo1JdbcTemplate")
    private NamedParameterJdbcTemplate demo1JdbcTemplate;

    // @Autowired
    // @Qualifier("demo2JdbcTemplate")
    // private NamedParameterJdbcTemplate demo2JdbcTemplate;
    @Autowired
    StaffService service;

    private final static Logger log = LoggerFactory.getLogger(StaffController.class);

    @PostMapping("/staff")
    public String createStaff(@RequestBody Staff staff) {
        String sql = "insert into staff(id,name,account) values(:id,:name,:account)";
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", staff.getId());
        map.put("name", staff.getName());
        map.put("account", staff.getAccount());
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        demo1JdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int keyValue = keyHolder.getKey().intValue();
        System.out.println("auto_increment test 123 id:" + keyValue);

        return "post staff" + keyValue;
    }

    // @PostMapping("/staffs")
    // public String createStaffs(@RequestBody List<Staff> staffs) {
    //     String sql = "insert into staff(id,name,account) values(:id,:name,:account)";
    //     MapSqlParameterSource[] sqlParameterSources = new MapSqlParameterSource[staffs.size()];
    //     demo1JdbcTemplate.batchUpdate(sql, sqlParameterSources);
    //     return "post staffs";
    // }

    @GetMapping("/staffs/{id}")
    public Staff queryStaffs(@PathVariable("id") Integer id) {
        log.info("ooo what you say~~a~~~, come anybody want to say~~ a~~~");

        // String sql = "select Id,Name,Account from staff where id = :id";
        // MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        // mapSqlParameterSource.addValue("id", id);
        // // HashMap<String,Object> map = new HashMap<>();
        // // map.put("id",id);

        // // List<Staff> result = namedParameterJdbcTemplate.query(sql, mapSqlParameterSource,new StaffRowMapper());
        // List<Staff> result = namedParameterJdbcTemplate.query(sql, mapSqlParameterSource,new BeanPropertyRowMapper<>(Staff.class));
        // return result;
        System.out.println("find by id " + id);
        return service.findById(id);
    }

    
}
