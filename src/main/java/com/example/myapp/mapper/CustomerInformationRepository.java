package com.example.myapp.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.entity.CustomerInformation;

public interface CustomerInformationRepository extends JpaRepository<CustomerInformation, Integer> {

}
