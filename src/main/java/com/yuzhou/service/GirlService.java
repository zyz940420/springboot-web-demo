package com.yuzhou.service;

import com.yuzhou.mapper.GirlMapper;
import com.yuzhou.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlMapper mapper;

    @Transactional
    public boolean insertTwo() {
        Girl girlA = new Girl();
        girlA.setId(11);
        girlA.setAge(11);
        girlA.setCupSize("a");
        mapper.save(girlA);

        Girl girlB = new Girl();
        girlB.setId(55);
        girlB.setAge(55);
        girlB.setCupSize("bbbbbb");
        mapper.save(girlB);

        return true;
    }
}
