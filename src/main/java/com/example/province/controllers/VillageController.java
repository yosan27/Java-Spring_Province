package com.example.province.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.province.dto.VillageDto;
import com.example.province.services.VillageServiceImplement;

@RestController
@RequestMapping("/village")
public class VillageController {
	
	@Autowired
	VillageServiceImplement service;
	
	@GetMapping("/get-all")
	ResponseEntity<?> getAll (){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/get-by-code/{code}")
	ResponseEntity<?> getByCode (@PathVariable String code){
		return ResponseEntity.ok(service.getByCode(code));
	}
	
	@GetMapping("/get-by-sub-district/{code}")
	ResponseEntity<?> getBySubDistrict (@PathVariable String code){
		return ResponseEntity.ok(service.getBySubDistrictCode(code));
	}
	
	@GetMapping("/get-by-district/{code}")
	ResponseEntity<?> getByDistrict (@PathVariable String code){
		return ResponseEntity.ok(service.getByDistrictCode(code));
	}
	
	@GetMapping("/get-by-province/{code}")
	ResponseEntity<?> getByProvince (@PathVariable String code){
		return ResponseEntity.ok(service.getByProvinceCode(code));
	}
	
	@PostMapping("/post")
	ResponseEntity<?> post (@RequestBody VillageDto dto){
		return ResponseEntity.ok(service.post(dto));
	}
	
	@PutMapping("/update/{id}")
	ResponseEntity<?> post (@RequestBody VillageDto dto, @PathVariable Integer id){
		return ResponseEntity.ok(service.update(dto, id));
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<?> post (@PathVariable Integer id){
		return ResponseEntity.ok(service.delete(id));
	}
}
