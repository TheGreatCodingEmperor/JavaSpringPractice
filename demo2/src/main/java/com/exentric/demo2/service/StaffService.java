package com.exentric.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exentric.demo2.dao.StaffDao;
import com.exentric.demo2.dto.Staff;

@Component
public class StaffService implements IStaffService {
    @Autowired
    StaffDao dao;
    @Override
    public Staff findById(Integer id) {
        return dao.findById(id);
    }
    
}
