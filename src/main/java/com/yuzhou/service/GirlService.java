package com.yuzhou.service;

import com.yuzhou.enums.ResultEnum;
import com.yuzhou.exception.GirlException;
import com.yuzhou.mapper.GirlMapper;
import com.yuzhou.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    public void getAge(Integer id) throws Exception {
        Optional<Girl> girl = mapper.findById(id);
        if (girl.get().getAge() < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (girl.get().getAge() > 10 && girl.get().getAge() < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        } else {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 查找一条记录
     * @param id
     * @return
     */
    public Optional<Girl> findOne(Integer id) {
        return mapper.findById(id);
    }
}
