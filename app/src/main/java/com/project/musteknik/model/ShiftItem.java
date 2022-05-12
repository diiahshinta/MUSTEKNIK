package com.project.musteknik.model;

import com.google.gson.annotations.SerializedName;

public class ShiftItem{

	@SerializedName("plant_id")
	private int plantId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("whenDeleted")
	private Object whenDeleted;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	public int getPlantId(){
		return plantId;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public Object getWhenDeleted(){
		return whenDeleted;
	}

	public String getName(){
		return name;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}
}