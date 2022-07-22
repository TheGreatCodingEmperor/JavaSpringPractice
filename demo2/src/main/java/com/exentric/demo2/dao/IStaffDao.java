package com.exentric.demo2.dao;

import com.exentric.demo2.dto.Staff;

public interface IStaffDao {
    public Staff create(Staff staff);
    public Staff findById(Integer id);
}
