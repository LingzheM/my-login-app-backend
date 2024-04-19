package com.example.myapp.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.entity.StaffDetail;

public interface StaffDetailRepository extends JpaRepository<StaffDetail, Integer> {
	
	//  torihiki_id によって、全ての担当者を検索
    List<StaffDetail> findByTorihikiId(Integer torihikiId);

}
