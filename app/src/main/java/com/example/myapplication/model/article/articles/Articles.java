package com.example.myapplication.model.article.articles;

import com.google.gson.annotations.SerializedName;

public class Articles{

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("response")
	private Response response;

	@SerializedName("status")
	private String status;

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return copyright;
	}

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}