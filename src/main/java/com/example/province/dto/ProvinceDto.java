package com.example.province.dto;

public class ProvinceDto {
	private Integer id;
	private String provinceCode;
	private String provinceName;
	private String status;

	
	public ProvinceDto(Integer id, String provinceCode, String provinceName, String status) {
		super();
		this.id = id;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
		this.status = status;
	}

	
	public ProvinceDto() {
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

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
}
