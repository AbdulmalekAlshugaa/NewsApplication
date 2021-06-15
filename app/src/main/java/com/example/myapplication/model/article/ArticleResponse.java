package com.example.myapplication.model.article;

import com.google.gson.annotations.SerializedName;

public class ArticleResponse{

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("response")
	private Response response;

	@SerializedName("status")
	private String status;

	public String getCopyright(){
		return copyright;
	}

	public Response getResponse(){
		return response;
	}

	public String getStatus(){
		return status;
	}
}