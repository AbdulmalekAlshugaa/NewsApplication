package com.example.myapplication.model.article.articles;

import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("hits")
	private int hits;

	@SerializedName("offset")
	private int offset;

	@SerializedName("time")
	private int time;

	public void setHits(int hits){
		this.hits = hits;
	}

	public int getHits(){
		return hits;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setTime(int time){
		this.time = time;
	}

	public int getTime(){
		return time;
	}
}