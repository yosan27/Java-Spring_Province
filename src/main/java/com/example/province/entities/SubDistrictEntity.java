package com.example.province.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_district_entity")
public class SubDistrictEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "sub_district_name", nullable = false)
	private String subDistrictName;
	
	@Column(name = "sub_district_code", nullable = false, unique = true, length = 10)
	private String subDistrictCode;
	
	@ManyToOne
	@JoinColumn(name = "district_code", nullable = false, referencedColumnName = "district_code")
	private DistrictEntity districtEntity;
	
	@ManyToOne
	@JoinColumn(name = "province_code", nullable = false, referencedColumnName = "province_code")
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

	public String getSubDistrictName() {
		return subDistrictName;
	}

	public void setSubDistrictName(String subDistrictName) {
		this.subDistrictName = subDistrictName;
	}

	public String getSubDistrictCode() {
		return subDistrictCode;
	}

	public void setSubDistrictCode(String subDistrictCode) {
		this.subDistrictCode = subDistrictCode;
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
