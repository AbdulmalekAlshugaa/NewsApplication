package com.example.myapplication.model.article;

import com.google.gson.annotations.SerializedName;

public class Legacy{

	@SerializedName("widewidth")
	private int widewidth;

	@SerializedName("wideheight")
	private int wideheight;

	@SerializedName("wide")
	private String wide;

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("thumbnailwidth")
	private int thumbnailwidth;

	@SerializedName("thumbnailheight")
	private int thumbnailheight;

	@SerializedName("xlarge")
	private String xlarge;

	@SerializedName("xlargewidth")
	private int xlargewidth;

	@SerializedName("xlargeheight")
	private int xlargeheight;

	public int getWidewidth(){
		return widewidth;
	}

	public int getWideheight(){
		return wideheight;
	}

	public String getWide(){
		return wide;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public int getThumbnailwidth(){
		return thumbnailwidth;
	}

	public int getThumbnailheight(){
		return thumbnailheight;
	}

	public String getXlarge(){
		return xlarge;
	}

	public int getXlargewidth(){
		return xlargewidth;
	}

	public int getXlargeheight(){
		return xlargeheight;
	}
}