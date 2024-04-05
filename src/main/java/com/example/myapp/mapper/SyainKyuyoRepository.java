 package com.example.myapp.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.entity.SyainKyuyo;

public interface SyainKyuyoRepository extends JpaRepository<SyainKyuyo, Integer> {
	
	List<SyainKyuyo> findBySyainId(Integer id);
	
}


