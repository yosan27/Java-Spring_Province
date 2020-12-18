package com.example.province.services;

import org.springframework.http.ResponseEntity;

import com.example.province.dto.DistrictDto;

public interface DistrictService {
	ResponseEntity<?> getAll ();
	ResponseEntity<?> getByCode(String code);
	ResponseEntity<?> getByProvinceCode(String code);
	ResponseEntity<?> post (DistrictDto dto);
	ResponseEntity<?> update(DistrictDto dto, Integer id);
	ResponseEntity<?> delete(Integer id);
}
