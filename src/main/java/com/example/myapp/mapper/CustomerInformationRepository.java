package com.example.myapp.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.entity.CustomerInformation;

public interface CustomerInformationRepository extends JpaRepository<CustomerInformation, Integer> {
	
	// 根据name进行like搜索，如果name为空，则忽略name条件
    // 当source为1时搜索HONSYA字段值为1的数据，为2时搜索HONSYA字段值为2的数据
	    
	List<CustomerInformation> findByTorihikiNameAllContainingAndHonsya(String torihikiNameAll, Integer honsya);

}
