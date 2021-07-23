package com.example.rapor.model.login;

import com.google.gson.annotations.SerializedName;

public class LData {

	@SerializedName("nomor_induk")
	private String nomorInduk;

	@SerializedName("name")
	private String name;

	@SerializedName("email")
	private String email;

	public void setNomorInduk(String nomorInduk){
		this.nomorInduk = nomorInduk;
	}

	public String getNomorInduk(){
		return nomorInduk;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

}