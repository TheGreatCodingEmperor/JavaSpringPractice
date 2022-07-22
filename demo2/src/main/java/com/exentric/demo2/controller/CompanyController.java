package com.exentric.demo2.controller;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exentric.demo2.dto.Company;

@RestController
public class CompanyController {
    // @Autowired
    // private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    @Qualifier("demo1JdbcTemplate")
    private NamedParameterJdbcTemplate demo1JdbcTemplate;

    // @Autowired
    // @Qualifier("demo2JdbcTemplate")
    // private NamedParameterJdbcTemplate demo2JdbcTemplate;

    @PostMapping("/company")
    public String create(@Valid @RequestBody Company company) {
        throw new RuntimeException("action create error");
    }

    // @GetMapping("/company")
    // public String get() {
    //     return namedParameterJdbcTemplate.query("select * from company");
    // }

    // @GetMapping("/company/2")
    // public ResponseEntity<String> query2(@RequestParam String name) {
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("name",name);
    //     namedParameterJdbcTemplate.query("select * from company where name=:", map,new RowMapper<Company>() {
    //         @Override
    //         public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
    //             Company company = new Company();
    //         company.setId(rs.getInt("id"));
    //         company.setName(rs.getString("name"));
    //         company.setTel(tel);(rs.getString("tel"));
    //     });
    //     return ResponseEntity.status(HttpStatus.OK).body("action create!");
    // }

    @PostMapping("/company/2")
    public ResponseEntity<String> create2(@RequestBody Company company) {
        
        Map<String, Object> map = new HashMap<>();
        map.put("id",company.Id);
        map.put("name",company.Name);
        demo1JdbcTemplate.update("insert into company(id,name) values (:id,:name)", map);
        return ResponseEntity.status(HttpStatus.OK).body("action create!");
    }

    @PutMapping("/company/2")
    public ResponseEntity<String> create3(@RequestBody Company company) {
        String sql = "UPDATE company SET tel=:tel, name=:name  WHERE id=:id;";
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",company.Id);
        map.put("name",company.Name);
        map.put("tel",company.Tel);
        demo1JdbcTemplate.update(sql, map);
        return ResponseEntity.status(HttpStatus.OK).body("action create!");
    }

    @DeleteMapping("/company/2")
    public ResponseEntity<String> create3(@RequestParam int id) {
        String sql = "delete from company WHERE id=:id;";
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        demo1JdbcTemplate.update(sql, map);
        return ResponseEntity.status(HttpStatus.OK).body("action create!");
    }

}