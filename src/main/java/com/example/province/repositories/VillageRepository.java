package com.example.province.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.province.entities.VillageEntity;

@Repository
public interface VillageRepository extends JpaRepository<VillageEntity, Integer> {
	VillageEntity findByVillageCode(String code);
	
	@Query(value = "select * from village_entity where sub_district_code = ?", nativeQuery = true)
	List<VillageEntity> findBySubDistrictCode(String code);
	
	@Query(value = "select * from village_entity where district_code = ?", nativeQuery = true)
	List<VillageEntity> findByDistrictCode(String code);
	
	@Query(value = "select * from village_entity where province_code = ?", nativeQuery = true)
	List<VillageEntity> findByProvinceCode(String code);
}
