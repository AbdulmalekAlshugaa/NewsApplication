package com.example.myapplication.model.article.articles;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Byline{

	@SerializedName("original")
	private String original;

	@SerializedName("person")
	private List<PersonItem> person;

	@SerializedName("organization")
	private Object organization;

	public void setOriginal(String original){
		this.original = original;
	}

	public String getOriginal(){
		return original;
	}

	public void setPerson(List<PersonItem> person){
		this.person = person;
	}

	public List<PersonItem> getPerson(){
		return person;
	}

	public void setOrganization(Object organization){
		this.organization = organization;
	}

	public Object getOrganization(){
		return organization;
	}
}