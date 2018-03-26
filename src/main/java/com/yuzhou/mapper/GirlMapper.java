package com.yuzhou.mapper;

import com.yuzhou.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlMapper extends JpaRepository<Girl, Integer> {

    List<Girl> findByAge(Integer age);

    List<Girl> findByCupSize(String cupSize);
}
