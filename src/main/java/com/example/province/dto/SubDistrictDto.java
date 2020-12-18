package com.example.province.dto;

public class SubDistrictDto {
	private Integer id;
	private String subDistrictName;
	private String subDistrictCode;
	private String districtCode;
	private String provinceCode;
	private String status;
	
	
	
	public SubDistrictDto(Integer id, String subDistrictName, String subDistrictCode, String districtCode,
			String provinceCode, String status) {
		super();
		this.id = id;
		this.subDistrictName = subDistrictName;
		this.subDistrictCode = subDistrictCode;
		this.districtCode = districtCode;
		this.provinceCode = provinceCode;
		this.status = status;
	}


	public SubDistrictDto() {
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
