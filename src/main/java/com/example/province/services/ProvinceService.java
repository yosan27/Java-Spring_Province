package com.example.province.services;

import org.springframework.http.ResponseEntity;

import com.example.province.dto.ProvinceDto;

public interface ProvinceService {
	ResponseEntity<?> getAll();
	ResponseEntity<?> getById(Integer id);
	ResponseEntity<?> getByCode(String code);
	ResponseEntity<?> post(ProvinceDto dto);
	ResponseEntity<?> delete(Integer id);
	ResponseEntity<?> restore(Integer id);
	ResponseEntity<?> update(ProvinceDto dto, Integer id);
}
