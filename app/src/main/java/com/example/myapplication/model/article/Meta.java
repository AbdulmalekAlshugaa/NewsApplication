package com.example.myapplication.model.article;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("hits")
	private int hits;

	@SerializedName("offset")
	private int offset;

	@SerializedName("time")
	private int time;

	public int getHits(){
		return hits;
	}

	public int getOffset(){
		return offset;
	}

	public int getTime(){
		return time;
	}
}