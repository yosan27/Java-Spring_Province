package com.example.province.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.province.dto.DistrictDto;
import com.example.province.dto.StatusDto;
import com.example.province.entities.DistrictEntity;
import com.example.province.entities.ProvinceEntity;
import com.example.province.repositories.DistrictRepository;
import com.example.province.repositories.ProvinceRepository;

@Service
@Transactional
public class DistrictServiceImplement implements DistrictService {

	@Autowired
	DistrictRepository districtRepository;
	
	@Autowired
	ProvinceRepository provinceRepository;
	
	@Override
	public ResponseEntity<?> getAll() {
		List<DistrictEntity> districtEntity = districtRepository.findAll();
		return ResponseEntity.ok(districtEntity);
	}

	@Override
	public ResponseEntity<?> getByCode(String code) {
		DistrictEntity districtEntity = districtRepository.findByDistrictCode(code);
		return ResponseEntity.ok(districtEntity);
	}

	@Override
	public ResponseEntity<?> post(DistrictDto dto) {
		StatusDto<DistrictEntity> result = new StatusDto<>();
		if(dto.getProvinceCode().length() < 3 || dto.getProvinceCode().length() > 3) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("Province Code Less Or More Than 3");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else if(dto.getDistrictCode().length() < 7 || dto.getDistrictCode().length() > 7) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("District Code Less Or More Than 7");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			DistrictEntity districtEntity = convert(dto);
			ProvinceEntity provinceEntity = provinceRepository.findByProvinceCode(dto.getProvinceCode());
			districtEntity.setProvinceEntity(provinceEntity);
			districtRepository.save(districtEntity);
			return ResponseEntity.ok(districtEntity);
		}
	}

	@Override
	public ResponseEntity<?> update(DistrictDto dto, Integer id) {
		StatusDto<DistrictEntity> result = new StatusDto<>();
		if(dto.getProvinceCode().length() < 3 || dto.getProvinceCode().length() > 3) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("Province Code Less Or More Than 3");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else if(dto.getDistrictCode().length() < 7 || dto.getDistrictCode().length() > 7) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("District Code Less Or More Than 7");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			DistrictEntity districtEntity = districtRepository.findById(id).get();
			ProvinceEntity provinceEntity = provinceRepository.findByProvinceCode(dto.getProvinceCode());
			districtEntity.setDistrictName(dto.getDistrictName());
			districtEntity.setDistrictCode(dto.getDistrictCode());
			districtEntity.setProvinceEntity(provinceEntity);
			districtRepository.save(districtEntity);
			return ResponseEntity.ok(districtEntity);
		}
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		DistrictEntity districtEntity = districtRepository.findById(id).get();
		districtEntity.setStatus("1");
		districtRepository.save(districtEntity);
		StatusDto<DistrictEntity> result = new StatusDto<>();
		result.setStatus("200");
		result.setMessage("Deleted!");
		result.setData(districtEntity);
		return ResponseEntity.ok(result);
	}
	
	@Override
	public ResponseEntity<?> getByProvinceCode(String code) {
		List<DistrictEntity> districtEntity = districtRepository.findByProvinceCode(code);
		return ResponseEntity.ok(districtEntity);
	}
	
	public DistrictEntity convert(DistrictDto dto) {
		DistrictEntity districtEntity = new DistrictEntity();
		districtEntity.setDistrictName(dto.getDistrictName());
		districtEntity.setDistrictCode(dto.getDistrictCode());
		districtEntity.setStatus("0");
		return districtEntity;
	}
}
