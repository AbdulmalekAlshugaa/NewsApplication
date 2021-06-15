package com.example.myapplication.model.article.articles;

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

	public void setLegacy(Legacy legacy){
		this.legacy = legacy;
	}

	public Legacy getLegacy(){
		return legacy;
	}

	public void setSubtype(String subtype){
		this.subtype = subtype;
	}

	public String getSubtype(){
		return subtype;
	}

	public void setCropName(String cropName){
		this.cropName = cropName;
	}

	public String getCropName(){
		return cropName;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setCaption(Object caption){
		this.caption = caption;
	}

	public Object getCaption(){
		return caption;
	}

	public void setSubType(String subType){
		this.subType = subType;
	}

	public String getSubType(){
		return subType;
	}

	public void setCredit(Object credit){
		this.credit = credit;
	}

	public Object getCredit(){
		return credit;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}
}