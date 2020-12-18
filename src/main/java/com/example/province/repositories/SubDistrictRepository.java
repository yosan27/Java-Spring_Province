package com.example.province.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.province.entities.SubDistrictEntity;

@Repository
public interface SubDistrictRepository extends JpaRepository<SubDistrictEntity, Integer>{
	SubDistrictEntity findBySubDistrictCode (String code);
	
	@Query(value = "select * from sub_district_entity where province_code = ?", nativeQuery = true)
	List<SubDistrictEntity> findByProvinceCode (String code);
	
	@Query(value = "select * from sub_district_entity where district_code = ?", nativeQuery = true)
	List<SubDistrictEntity> findByDistrictCode (String code);
}
