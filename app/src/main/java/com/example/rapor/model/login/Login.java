package com.example.rapor.model.login;

import com.google.gson.annotations.SerializedName;

public class Login {

	@SerializedName("LData")
	private LData LData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setLData(LData LData){
		this.LData = LData;
	}

	public LData getLData(){
		return LData;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}