package com.example.province.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.province.dto.ProvinceDto;
import com.example.province.dto.StatusDto;
import com.example.province.entities.ProvinceEntity;
import com.example.province.repositories.ProvinceRepository;

@Service
@Transactional
public class ProvinceServiceImplement implements ProvinceService{

	@Autowired
	ProvinceRepository provinceRepository;
	
	@Autowired
	ValidateExpressions validationService;
	
	@Override
	public ResponseEntity<?> getAll() {
		List<ProvinceEntity> provinceEntity = provinceRepository.findAll();
		return ResponseEntity.ok(provinceEntity);
	}

	@Override
	public ResponseEntity<?> getByCode(String code) {
		ProvinceEntity provinceEntity = provinceRepository.findByProvinceCode(code);
		return ResponseEntity.ok(provinceEntity);
	}

	@Override
	public ResponseEntity<?> post(ProvinceDto dto) {
		StatusDto<ProvinceEntity> result = new StatusDto<>();
		boolean check = validationService.isValidName(dto.getProvinceName());
		if(check == false) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("Invalid Name");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else if(dto.getProvinceCode().length() < 3 || dto.getProvinceCode().length() > 3) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("Province Code Less Or More Than 3");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			ProvinceEntity provinceEntity = convert(dto);
			provinceRepository.save(provinceEntity);
			return ResponseEntity.ok(provinceEntity);
		}
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		ProvinceEntity provinceEntity = provinceRepository.findById(id).get();
		provinceEntity.setStatus("1");
		provinceRepository.save(provinceEntity);
		StatusDto<ProvinceEntity> result = new StatusDto<>();
		result.setStatus("200");
		result.setMessage("Deleted!");
		result.setData(provinceEntity);
		return ResponseEntity.ok(result);
	}

	@Override
	public ResponseEntity<?> update(ProvinceDto dto, Integer id) {
		StatusDto<ProvinceEntity> result = new StatusDto<>();
		if(dto.getProvinceCode().length() < 3 || dto.getProvinceCode().length() > 3) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("Province Code Less Or More Than 3");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			ProvinceEntity provinceEntity = provinceRepository.findById(id).get();
			provinceEntity.setProvinceName(dto.getProvinceName());
			provinceEntity.setProvinceCode(dto.getProvinceCode());
			provinceRepository.save(provinceEntity);
			return ResponseEntity.ok(provinceEntity);
		}
	}
	
	public ProvinceEntity convert(ProvinceDto dto) {
		ProvinceEntity provinceEntity = new ProvinceEntity();
		provinceEntity.setProvinceName(dto.getProvinceName());
		provinceEntity.setProvinceCode(dto.getProvinceCode());
		provinceEntity.setStatus("0");
		return provinceEntity;
	}

}
