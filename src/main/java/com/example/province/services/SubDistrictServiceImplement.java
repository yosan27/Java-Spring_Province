package com.example.province.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.province.dto.StatusDto;
import com.example.province.dto.SubDistrictDto;
import com.example.province.entities.DistrictEntity;
import com.example.province.entities.ProvinceEntity;
import com.example.province.entities.SubDistrictEntity;
import com.example.province.repositories.DistrictRepository;
import com.example.province.repositories.ProvinceRepository;
import com.example.province.repositories.SubDistrictRepository;

@Service
@Transactional
public class SubDistrictServiceImplement implements SubDistrictService {

	@Autowired
	SubDistrictRepository subDistrictRepository;
	
	@Autowired
	DistrictRepository districtRepository;
	
	@Autowired
	ProvinceRepository provinceRepository;
	
	@Override
	public ResponseEntity<?> getAll() {
		List<SubDistrictEntity> subDistrictEntity = subDistrictRepository.findAll();
		return ResponseEntity.ok(subDistrictEntity);
	}

	@Override
	public ResponseEntity<?> getByCode(String code) {
		SubDistrictEntity subDistrictEntity = subDistrictRepository.findBySubDistrictCode(code);
		return ResponseEntity.ok(subDistrictEntity);
	}

	@Override
	public ResponseEntity<?> getByDistrictCode(String code) {
		List<SubDistrictEntity> subDistrictEntity = subDistrictRepository.findByDistrictCode(code);
		return ResponseEntity.ok(subDistrictEntity);
	}

	@Override
	public ResponseEntity<?> getByProvinceCode(String code) {
		List<SubDistrictEntity> subDistrictEntity = subDistrictRepository.findByProvinceCode(code);
		return ResponseEntity.ok(subDistrictEntity);
	}

	@Override
	public ResponseEntity<?> post(SubDistrictDto dto) {
		StatusDto<SubDistrictEntity> result = new StatusDto<>();
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
		}else if(dto.getSubDistrictCode().length() < 10 || dto.getSubDistrictCode().length() > 10) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("Sub District Code Less Or More Than 10");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			SubDistrictEntity subDistrictEntity = convert(dto);
			DistrictEntity districtEntity = districtRepository.findByDistrictCode(dto.getDistrictCode());
			subDistrictEntity.setDistrictEntity(districtEntity);
			ProvinceEntity provinceEntity = provinceRepository.findByProvinceCode(dto.getProvinceCode());
			subDistrictEntity.setProvinceEntity(provinceEntity);
			subDistrictRepository.save(subDistrictEntity);
			return ResponseEntity.ok(subDistrictEntity);
		}
	}

	@Override
	public ResponseEntity<?> update(SubDistrictDto dto, Integer id) {
		StatusDto<SubDistrictEntity> result = new StatusDto<>();
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
		}else if(dto.getSubDistrictCode().length() < 10 || dto.getSubDistrictCode().length() > 10) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("Sub District Code Less Or More Than 10");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			SubDistrictEntity subDistrictEntity = subDistrictRepository.findById(id).get();
			subDistrictEntity.setSubDistrictName(dto.getSubDistrictName());
			subDistrictEntity.setSubDistrictCode(dto.getSubDistrictCode());
			DistrictEntity districtEntity = districtRepository.findByDistrictCode(dto.getDistrictCode());
			subDistrictEntity.setDistrictEntity(districtEntity);
			ProvinceEntity provinceEntity = provinceRepository.findByProvinceCode(dto.getProvinceCode());
			subDistrictEntity.setProvinceEntity(provinceEntity);
			subDistrictRepository.save(subDistrictEntity);
			return ResponseEntity.ok(subDistrictEntity);
		}
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		SubDistrictEntity subDistrictEntity = subDistrictRepository.findById(id).get();
		subDistrictEntity.setStatus("1");
		subDistrictRepository.save(subDistrictEntity);
		StatusDto<SubDistrictEntity> result = new StatusDto<>();
		result.setStatus("200");
		result.setMessage("Deleted!");
		result.setData(subDistrictEntity);
		return ResponseEntity.ok(result);
	}
	
	public SubDistrictEntity convert(SubDistrictDto dto) {
		SubDistrictEntity subDistrictEntity = new SubDistrictEntity();
		subDistrictEntity.setSubDistrictName(dto.getSubDistrictName());
		subDistrictEntity.setSubDistrictCode(dto.getSubDistrictCode());
		subDistrictEntity.setStatus("0");
		return subDistrictEntity;
	}

}
