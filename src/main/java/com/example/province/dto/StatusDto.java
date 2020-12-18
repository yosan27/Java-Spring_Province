package com.example.province.dto;

public class StatusDto<T> {
	private String status;
	private String message;
	private T data;
	
	
	public StatusDto(String status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	
	public StatusDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}
}
