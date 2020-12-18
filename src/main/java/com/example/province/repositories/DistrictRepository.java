package com.example.province.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.province.entities.DistrictEntity;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, Integer>{
	DistrictEntity findByDistrictCode(String code);
	
	@Query(value = "select * from district_entity where province_code = ?", nativeQuery = true)
	List<DistrictEntity> findByProvinceCode(String code);
}
