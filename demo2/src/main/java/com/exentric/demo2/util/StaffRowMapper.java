package com.exentric.demo2.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.exentric.demo2.dto.Staff;

public class StaffRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Staff staff = new Staff();
        staff.setId(rs.getInt("Id"));
        staff.setName(rs.getString("Name"));
        staff.setAccount(rs.getString("Account"));
        return staff;
    }
}
