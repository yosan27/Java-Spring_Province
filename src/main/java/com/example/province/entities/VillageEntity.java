package com.example.province.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "village_entity")
public class VillageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "village_name", nullable = false)
	private String villageName;
	
	@Column(name = "village_code", nullable = false, unique = true, length = 15)
	private String villageCode;
	
	@ManyToOne
	@JoinColumn(name = "sub_district_code", nullable = false, unique = true, referencedColumnName = "sub_district_code")
	private SubDistrictEntity subDistrictEntity;
	
	@ManyToOne
	@JoinColumn(name = "district_code", nullable = false, unique = true, referencedColumnName = "district_code")
	private DistrictEntity districtEntity;
	
	@ManyToOne
	@JoinColumn(name = "province_code", nullable = false, unique = true, referencedColumnName = "province_code")
	private ProvinceEntity provinceEntity;
	
	@Column(name = "status", nullable = false, length = 1)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public SubDistrictEntity getSubDistrictEntity() {
		return subDistrictEntity;
	}

	public void setSubDistrictEntity(SubDistrictEntity subDistrictEntity) {
		this.subDistrictEntity = subDistrictEntity;
	}

	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}

	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}

	public ProvinceEntity getProvinceEntity() {
		return provinceEntity;
	}

	public void setProvinceEntity(ProvinceEntity provinceEntity) {
		this.provinceEntity = provinceEntity;
	}	
}
