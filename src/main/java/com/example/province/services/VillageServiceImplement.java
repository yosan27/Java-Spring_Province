package com.example.province.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.province.dto.StatusDto;
import com.example.province.dto.VillageDto;
import com.example.province.entities.DistrictEntity;
import com.example.province.entities.ProvinceEntity;
import com.example.province.entities.SubDistrictEntity;
import com.example.province.entities.VillageEntity;
import com.example.province.repositories.DistrictRepository;
import com.example.province.repositories.ProvinceRepository;
import com.example.province.repositories.SubDistrictRepository;
import com.example.province.repositories.VillageRepository;

@Service
@Transactional
public class VillageServiceImplement implements VillageService {
	@Autowired
	VillageRepository villageRepository;
	
	@Autowired
	SubDistrictRepository subDistrictRepository;
	
	@Autowired
	DistrictRepository districtRepository;
	
	@Autowired
	ProvinceRepository provinceRepository;

	@Override
	public ResponseEntity<?> getAll() {
		List<VillageEntity> villageEntity = villageRepository.findAll();
		return ResponseEntity.ok(villageEntity);
	}

	@Override
	public ResponseEntity<?> getByCode(String code) {
		VillageEntity villageEntity = villageRepository.findByVillageCode(code);
		return ResponseEntity.ok(villageEntity);
	}

	@Override
	public ResponseEntity<?> getBySubDistrictCode(String code) {
		List<VillageEntity> villageEntity = villageRepository.findBySubDistrictCode(code);
		return ResponseEntity.ok(villageEntity);
	}

	@Override
	public ResponseEntity<?> getByDistrictCode(String code) {
		List<VillageEntity> villageEntity = villageRepository.findByDistrictCode(code);
		return ResponseEntity.ok(villageEntity);
	}

	@Override
	public ResponseEntity<?> getByProvinceCode(String code) {
		List<VillageEntity> villageEntity = villageRepository.findByProvinceCode(code);
		return ResponseEntity.ok(villageEntity);
	}

	@Override
	public ResponseEntity<?> post(VillageDto dto) {
		StatusDto<VillageEntity> result = new StatusDto<>();
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
		}else if(dto.getVillageCode().length() < 15 || dto.getVillageCode().length() > 15) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("Village Code Less Or More Than 15");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			VillageEntity villageEntity = convert(dto);
			SubDistrictEntity subDistrictEntity = subDistrictRepository.findBySubDistrictCode(dto.getSubDistrictCode());
			villageEntity.setSubDistrictEntity(subDistrictEntity);
			DistrictEntity districtEntity = districtRepository.findByDistrictCode(dto.getDistrictCode());
			villageEntity.setDistrictEntity(districtEntity);
			ProvinceEntity provinceEntity = provinceRepository.findByProvinceCode(dto.getProvinceCode());
			villageEntity.setProvinceEntity(provinceEntity);
			villageRepository.save(villageEntity);
			return ResponseEntity.ok(villageEntity);
		}
	}

	@Override
	public ResponseEntity<?> update(VillageDto dto, Integer id) {
		StatusDto<VillageEntity> result = new StatusDto<>();
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
		}else if(dto.getVillageCode().length() < 15 || dto.getVillageCode().length() > 15) {
			result.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			result.setMessage("Village Code Less Or More Than 15");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		}else {
			VillageEntity villageEntity = villageRepository.findById(id).get();
			villageEntity.setVillageName(dto.getVillageName());
			villageEntity.setVillageCode(dto.getVillageCode());
			SubDistrictEntity subDistrictEntity = subDistrictRepository.findBySubDistrictCode(dto.getSubDistrictCode());
			villageEntity.setSubDistrictEntity(subDistrictEntity);
			DistrictEntity districtEntity = districtRepository.findByDistrictCode(dto.getDistrictCode());
			villageEntity.setDistrictEntity(districtEntity);
			ProvinceEntity provinceEntity = provinceRepository.findByProvinceCode(dto.getProvinceCode());
			villageEntity.setProvinceEntity(provinceEntity);
			villageRepository.save(villageEntity);
			return ResponseEntity.ok(villageEntity);
		}
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		VillageEntity villageEntity = villageRepository.findById(id).get();
		villageEntity.setStatus("1");
		villageRepository.save(villageEntity);
		StatusDto<VillageEntity> result = new StatusDto<>();
		result.setStatus("200");
		result.setMessage("Deleted!");
		result.setData(villageEntity);
		return ResponseEntity.ok(result);
	}
	
	public VillageEntity convert(VillageDto dto) {
		VillageEntity villageEntity = new VillageEntity();
		villageEntity.setVillageName(dto.getVillageName());
		villageEntity.setVillageCode(dto.getVillageCode());
		villageEntity.setStatus("0");
		return villageEntity;
	}
	
	
}
