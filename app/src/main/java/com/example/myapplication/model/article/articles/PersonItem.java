package com.example.myapplication.model.article.articles;

import com.google.gson.annotations.SerializedName;

public class PersonItem{

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("role")
	private String role;

	@SerializedName("qualifier")
	private Object qualifier;

	@SerializedName("organization")
	private String organization;

	@SerializedName("middlename")
	private Object middlename;

	@SerializedName("rank")
	private int rank;

	@SerializedName("title")
	private Object title;

	@SerializedName("lastname")
	private String lastname;

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setQualifier(Object qualifier){
		this.qualifier = qualifier;
	}

	public Object getQualifier(){
		return qualifier;
	}

	public void setOrganization(String organization){
		this.organization = organization;
	}

	public String getOrganization(){
		return organization;
	}

	public void setMiddlename(Object middlename){
		this.middlename = middlename;
	}

	public Object getMiddlename(){
		return middlename;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setTitle(Object title){
		this.title = title;
	}

	public Object getTitle(){
		return title;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}
}