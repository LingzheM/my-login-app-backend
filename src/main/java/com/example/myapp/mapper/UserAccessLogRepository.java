package com.example.myapp.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.entity.UserAccessLog;

public interface UserAccessLogRepository extends JpaRepository<UserAccessLog, Integer> {

}
