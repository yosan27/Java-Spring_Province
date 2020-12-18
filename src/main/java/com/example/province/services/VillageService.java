package com.example.province.services;

import org.springframework.http.ResponseEntity;

import com.example.province.dto.VillageDto;

public interface VillageService {
	ResponseEntity<?> getAll ();
	ResponseEntity<?> getByCode (String code);
	ResponseEntity<?> getBySubDistrictCode (String code);
	ResponseEntity<?> getByDistrictCode (String code);
	ResponseEntity<?> getByProvinceCode (String code);
	ResponseEntity<?> post(VillageDto dto);
	ResponseEntity<?> update(VillageDto dto, Integer id);
	ResponseEntity<?> delete(Integer id);
}
