package com.example.myapplication.model.article;

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
	private String middlename;

	@SerializedName("rank")
	private int rank;

	@SerializedName("title")
	private Object title;

	@SerializedName("lastname")
	private String lastname;

	public String getFirstname(){
		return firstname;
	}

	public String getRole(){
		return role;
	}

	public Object getQualifier(){
		return qualifier;
	}

	public String getOrganization(){
		return organization;
	}

	public String getMiddlename(){
		return middlename;
	}

	public int getRank(){
		return rank;
	}

	public Object getTitle(){
		return title;
	}

	public String getLastname(){
		return lastname;
	}
}