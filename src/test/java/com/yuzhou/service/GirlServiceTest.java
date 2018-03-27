package com.yuzhou.service;

import com.yuzhou.model.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService service;

    @Test
    public void findOne() throws Exception {
        Girl girl = service.findOne(6).get();
        System.out.println(girl);
    }

}