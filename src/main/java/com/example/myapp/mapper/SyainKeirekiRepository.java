package com.example.myapp.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.entity.SyainKeireki;

public interface SyainKeirekiRepository extends JpaRepository<SyainKeireki, Integer> {

	List<SyainKeireki> findBySyainId(Integer syainId);
}
