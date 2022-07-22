package com.exentric.demo2.util;

import org.junit.jupiter.api.Test;

import com.exentric.demo2.dto.Staff;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {
    @Test
    public void test() throws JsonProcessingException{
        Staff staff = new Staff();
        staff.setId(1);
        staff.setName("name");
        staff.setAccount("213");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonstr = objectMapper.writeValueAsString(staff);
        System.out.println(jsonstr);
    }
}
