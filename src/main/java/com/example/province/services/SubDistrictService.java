package com.example.province.services;

import org.springframework.http.ResponseEntity;

import com.example.province.dto.SubDistrictDto;

public interface SubDistrictService {
	ResponseEntity<?> getAll();
	ResponseEntity<?> getByCode(String code);
	ResponseEntity<?> getByDistrictCode(String code);
	ResponseEntity<?> getByProvinceCode(String code);
	ResponseEntity<?> post(SubDistrictDto dto);
	ResponseEntity<?> update(SubDistrictDto dto, Integer id);
	ResponseEntity<?> delete(Integer id);
}
