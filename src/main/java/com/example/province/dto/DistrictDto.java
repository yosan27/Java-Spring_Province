package com.example.province.dto;

public class DistrictDto {
	private Integer id;
	private String districtName;
	private String districtCode;
	private String provinceCode;
	private String status;
	
	
	public DistrictDto(Integer id, String districtName, String districtCode, String provinceCode, String status) {
		super();
		this.id = id;
		this.districtName = districtName;
		this.districtCode = districtCode;
		this.provinceCode = provinceCode;
		this.status = status;
	}
	
	
	public DistrictDto() {
		super();
		// TODO Auto-generated constructor stub
	}


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
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	
}
