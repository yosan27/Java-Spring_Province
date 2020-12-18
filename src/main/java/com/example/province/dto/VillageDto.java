package com.example.province.dto;

public class VillageDto {
	private Integer id;
	private String villageName;
	private String villageCode;
	private String subDistrictCode;
	private String districtCode;
	private String provinceCode;
	private String status;
	
	
	public VillageDto(Integer id, String villageName, String villageCode, String subDistrictCode, String districtCode,
			String provinceCode, String status) {
		super();
		this.id = id;
		this.villageName = villageName;
		this.villageCode = villageCode;
		this.subDistrictCode = subDistrictCode;
		this.districtCode = districtCode;
		this.provinceCode = provinceCode;
		this.status = status;
	}


	public VillageDto() {
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
