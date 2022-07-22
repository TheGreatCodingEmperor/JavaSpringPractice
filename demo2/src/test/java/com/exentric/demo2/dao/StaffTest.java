package com.exentric.demo2.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.exentric.demo2.dto.Staff;

@SpringBootTest
@AutoConfigureMockMvc
public class StaffTest {
    @Autowired
    private StaffDao productDao;

    @Autowired
    private MockMvc mvc;

    @Test
    void findById() {
        Staff product = productDao.findById(2);
        assertNotNull(product);
        assertEquals("123", product.getName());
        assertEquals("456", product.getAccount());
    }

    @Test
    public void searchProduct() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        JSONObject request = new JSONObject()
                .put("name", "Harry Potter")
                .put("price", 450);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/staffs/3")
                .headers(httpHeaders)
                .content(request.toString());
        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is(200));

        // .andDo(print())
        // .andExpect(status().isCreated())
        // .andExpect(jsonPath("$.id").hasJsonPath())
        // .andExpect(jsonPath("$.name").value(request.getString("name")))
        // .andExpect(jsonPath("$.price").value(request.getInt("price")))
        // .andExpect(header().exists(HttpHeaders.LOCATION))
        // .andExpect(header().string(HttpHeaders.CONTENT_TYPE,
        // MediaType.APPLICATION_JSON_VALUE));

    }
}
