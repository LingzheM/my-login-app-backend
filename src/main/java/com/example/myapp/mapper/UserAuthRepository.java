package com.example.myapp.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.entity.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {
	UserAuth findByUserCode(String userCode);

}
