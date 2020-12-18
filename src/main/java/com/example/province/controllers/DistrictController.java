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

import com.example.province.dto.DistrictDto;
import com.example.province.services.DistrictServiceImplement;

@RestController
@RequestMapping("/district")
public class DistrictController {

	@Autowired
	DistrictServiceImplement service;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/get-by-code/{code}")
	public ResponseEntity<?> getByCode(@PathVariable String code){
		return ResponseEntity.ok(service.getByCode(code));
	}
	
	@GetMapping("/get-by-province/{code}")
	public ResponseEntity<?> getByProvinceCode(@PathVariable String code){
		return ResponseEntity.ok(service.getByProvinceCode(code));
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody DistrictDto dto){
		return ResponseEntity.ok(service.post(dto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> post(@RequestBody DistrictDto dto, @PathVariable Integer id){		service.update(dto, id);
		return ResponseEntity.ok(service.update(dto, id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> post(@PathVariable Integer id){
		return ResponseEntity.ok(service.delete(id));
	}
}
