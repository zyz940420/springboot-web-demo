package com.yuzhou.controller;

import com.yuzhou.mapper.GirlMapper;
import com.yuzhou.model.Girl;
import com.yuzhou.model.Result;
import com.yuzhou.service.GirlService;
import com.yuzhou.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlMapper mapper;
    @Autowired
    private GirlService service;

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return mapper.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setId(girl.getId());
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girl);
    }

    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> getGirlById(@PathVariable("id") Integer id) {
        return mapper.findById(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam(value = "cupSize", required = false, defaultValue = "f") String cupSize,
                           @RequestParam(value = "age", required = false, defaultValue = "18") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return mapper.saveAndFlush(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        mapper.deleteById(id);
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return mapper.findByAge(age);
    }

    @GetMapping(value = "/girls/cupSize/{cupSize}")
    public List<Girl> girlListByCupSize(@PathVariable("cupSize") String cupSize) {
        return mapper.findByCupSize(cupSize);
    }

    @PostMapping(value = "/girls/two")
    public boolean insertTwo() {
        boolean success = service.insertTwo();
        return success;
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id")Integer id) throws Exception {
        service.getAge(id);
    }

}
