package com.example.myapp.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.entity.SyainMain;

public interface SyainMainRepository extends JpaRepository<SyainMain, Integer> {

	List<SyainMain> findBySyozokuKaisyaAndSyokugyoKindAndFirstNameKanjiContainingAndDeleteFlag(
            Integer syozokuKaisya, Integer syokugyoKind, String firstNameKanji, Integer deleteFlag);
	
	List<SyainMain> findByFirstNameKanjiContainingAndSyokugyoKindAndDeleteFlag(String firstNameKanji, Integer syokugyoKind, Integer DeleteFlag);

	List<SyainMain> findBySyozokuKaisyaAndSyokugyoKindAndDeleteFlag(Integer syozokuKaisya, Integer syokugyoKind, Integer deleteFlag);

	List<SyainMain> findBySyozokuKaisyaAndSyokugyoKindAndTaisyaDateIsNull(Integer syozokuKaisya, Integer syokugyoKind);
	
	List<SyainMain> findBySyozokuKaisyaAndSyokugyoKindAndTaisyaDateIsNotNull(Integer syozokuKaisya, Integer syokugyoKind);
	
	List<SyainMain> findBySyozokuKaisyaAndSyokugyoKind(Integer syozokuKaisya, Integer syokugyoKind);
}
