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
@Table(name = "district_entity")
public class DistrictEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "district_name", nullable = false)
	private String districtName;
	
	@Column(name = "district_code", nullable = false, unique = true, length = 7)
	private String districtCode;
	
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

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public ProvinceEntity getProvinceEntity() {
		return provinceEntity;
	}

	public void setProvinceEntity(ProvinceEntity provinceEntity) {
		this.provinceEntity = provinceEntity;
	}
}
