package com.example.myapplication.model.article;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DocsItem{

	@SerializedName("snippet")
	private String snippet;

	@SerializedName("print_page")
	private String printPage;

	@SerializedName("keywords")
	private List<KeywordsItem> keywords;

	@SerializedName("section_name")
	private String sectionName;

	@SerializedName("abstract")
	private String jsonMemberAbstract;

	@SerializedName("source")
	private String source;

	@SerializedName("uri")
	private String uri;

	@SerializedName("news_desk")
	private String newsDesk;

	@SerializedName("pub_date")
	private String pubDate;

	@SerializedName("multimedia")
	private List<MultimediaItem> multimedia;

	@SerializedName("word_count")
	private int wordCount;

	@SerializedName("lead_paragraph")
	private String leadParagraph;

	@SerializedName("type_of_material")
	private String typeOfMaterial;

	@SerializedName("web_url")
	private String webUrl;

	@SerializedName("print_section")
	private String printSection;

	@SerializedName("_id")
	private String id;

	@SerializedName("subsection_name")
	private String subsectionName;

	@SerializedName("headline")
	private Headline headline;

	@SerializedName("byline")
	private Byline byline;

	@SerializedName("document_type")
	private String documentType;

	public String getSnippet(){
		return snippet;
	}

	public String getPrintPage(){
		return printPage;
	}

	public List<KeywordsItem> getKeywords(){
		return keywords;
	}

	public String getSectionName(){
		return sectionName;
	}

	public String getJsonMemberAbstract(){
		return jsonMemberAbstract;
	}

	public String getSource(){
		return source;
	}

	public String getUri(){
		return uri;
	}

	public String getNewsDesk(){
		return newsDesk;
	}

	public String getPubDate(){
		return pubDate;
	}

	public List<MultimediaItem> getMultimedia(){
		return multimedia;
	}

	public int getWordCount(){
		return wordCount;
	}

	public String getLeadParagraph(){
		return leadParagraph;
	}

	public String getTypeOfMaterial(){
		return typeOfMaterial;
	}

	public String getWebUrl(){
		return webUrl;
	}

	public String getPrintSection(){
		return printSection;
	}

	public String getId(){
		return id;
	}

	public String getSubsectionName(){
		return subsectionName;
	}

	public Headline getHeadline(){
		return headline;
	}

	public Byline getByline(){
		return byline;
	}

	public String getDocumentType(){
		return documentType;
	}
}