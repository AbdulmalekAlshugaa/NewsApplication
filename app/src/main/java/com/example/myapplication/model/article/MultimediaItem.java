package com.example.myapplication.model.article;

import com.google.gson.annotations.SerializedName;

public class MultimediaItem{

	@SerializedName("legacy")
	private Legacy legacy;

	@SerializedName("subtype")
	private String subtype;

	@SerializedName("crop_name")
	private String cropName;

	@SerializedName("width")
	private int width;

	@SerializedName("rank")
	private int rank;

	@SerializedName("caption")
	private Object caption;

	@SerializedName("subType")
	private String subType;

	@SerializedName("credit")
	private Object credit;

	@SerializedName("type")
	private String type;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;

	public Legacy getLegacy(){
		return legacy;
	}

	public String getSubtype(){
		return subtype;
	}

	public String getCropName(){
		return cropName;
	}

	public int getWidth(){
		return width;
	}

	public int getRank(){
		return rank;
	}

	public Object getCaption(){
		return caption;
	}

	public String getSubType(){
		return subType;
	}

	public Object getCredit(){
		return credit;
	}

	public String getType(){
		return type;
	}

	public String getUrl(){
		return url;
	}

	public int getHeight(){
		return height;
	}
}