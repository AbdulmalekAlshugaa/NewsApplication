package com.example.myapplication.model.article.articles;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DocsItem{

	@SerializedName("snippet")
	private String snippet;

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

	@SerializedName("_id")
	private String id;

	@SerializedName("headline")
	private Headline headline;

	@SerializedName("byline")
	private Byline byline;

	@SerializedName("document_type")
	private String documentType;

	@SerializedName("print_page")
	private String printPage;

	@SerializedName("print_section")
	private String printSection;

	@SerializedName("subsection_name")
	private String subsectionName;

	public void setSnippet(String snippet){
		this.snippet = snippet;
	}

	public String getSnippet(){
		return snippet;
	}

	public void setKeywords(List<KeywordsItem> keywords){
		this.keywords = keywords;
	}

	public List<KeywordsItem> getKeywords(){
		return keywords;
	}

	public void setSectionName(String sectionName){
		this.sectionName = sectionName;
	}

	public String getSectionName(){
		return sectionName;
	}

	public void setJsonMemberAbstract(String jsonMemberAbstract){
		this.jsonMemberAbstract = jsonMemberAbstract;
	}

	public String getJsonMemberAbstract(){
		return jsonMemberAbstract;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}

	public void setNewsDesk(String newsDesk){
		this.newsDesk = newsDesk;
	}

	public String getNewsDesk(){
		return newsDesk;
	}

	public void setPubDate(String pubDate){
		this.pubDate = pubDate;
	}

	public String getPubDate(){
		return pubDate;
	}

	public void setMultimedia(List<MultimediaItem> multimedia){
		this.multimedia = multimedia;
	}

	public List<MultimediaItem> getMultimedia(){
		return multimedia;
	}

	public void setWordCount(int wordCount){
		this.wordCount = wordCount;
	}

	public int getWordCount(){
		return wordCount;
	}

	public void setLeadParagraph(String leadParagraph){
		this.leadParagraph = leadParagraph;
	}

	public String getLeadParagraph(){
		return leadParagraph;
	}

	public void setTypeOfMaterial(String typeOfMaterial){
		this.typeOfMaterial = typeOfMaterial;
	}

	public String getTypeOfMaterial(){
		return typeOfMaterial;
	}

	public void setWebUrl(String webUrl){
		this.webUrl = webUrl;
	}

	public String getWebUrl(){
		return webUrl;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setHeadline(Headline headline){
		this.headline = headline;
	}

	public Headline getHeadline(){
		return headline;
	}

	public void setByline(Byline byline){
		this.byline = byline;
	}

	public Byline getByline(){
		return byline;
	}

	public void setDocumentType(String documentType){
		this.documentType = documentType;
	}

	public String getDocumentType(){
		return documentType;
	}

	public void setPrintPage(String printPage){
		this.printPage = printPage;
	}

	public String getPrintPage(){
		return printPage;
	}

	public void setPrintSection(String printSection){
		this.printSection = printSection;
	}

	public String getPrintSection(){
		return printSection;
	}

	public void setSubsectionName(String subsectionName){
		this.subsectionName = subsectionName;
	}

	public String getSubsectionName(){
		return subsectionName;
	}
}