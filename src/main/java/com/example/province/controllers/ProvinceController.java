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

import com.example.province.dto.ProvinceDto;
import com.example.province.services.ProvinceServiceImplement;

@RestController
@RequestMapping("/province")
public class ProvinceController {

	@Autowired
	ProvinceServiceImplement serviceProvince;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(serviceProvince.getAll());
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(serviceProvince.getById(id));
	}
	
	@GetMapping("/get-by-code/{code}")
	public ResponseEntity<?> getByCode(@PathVariable String code){
		return ResponseEntity.ok(serviceProvince.getByCode(code));
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody ProvinceDto dto){
		return ResponseEntity.ok(serviceProvince.post(dto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody ProvinceDto dto, @PathVariable Integer id){
		return ResponseEntity.ok(serviceProvince.update(dto, id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		return ResponseEntity.ok(serviceProvince.delete(id));
	}
	
	@DeleteMapping("/restore/{id}")
	public ResponseEntity<?> restore(@PathVariable Integer id){
		return ResponseEntity.ok(serviceProvince.restore(id));
	}
}
