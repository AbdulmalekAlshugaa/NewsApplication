package com.example.myapplication.model.article.mostView;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("per_facet")
	private List<Object> perFacet;

	@SerializedName("eta_id")
	private int etaId;

	@SerializedName("subsection")
	private String subsection;

	@SerializedName("org_facet")
	private List<Object> orgFacet;

	@SerializedName("nytdsection")
	private String nytdsection;

	@SerializedName("column")
	private Object column;

	@SerializedName("section")
	private String section;

	@SerializedName("asset_id")
	private long assetId;

	@SerializedName("source")
	private String source;

	@SerializedName("abstract")
	private String jsonMemberAbstract;

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("type")
	private String type;

	@SerializedName("title")
	private String title;

	@SerializedName("des_facet")
	private List<String> desFacet;

	@SerializedName("uri")
	private String uri;

	@SerializedName("url")
	private String url;

	@SerializedName("adx_keywords")
	private String adxKeywords;

	@SerializedName("geo_facet")
	private List<String> geoFacet;

	@SerializedName("id")
	private long id;

	@SerializedName("published_date")
	private String publishedDate;

	@SerializedName("updated")
	private String updated;

	@SerializedName("byline")
	private String byline;

	public void setPerFacet(List<Object> perFacet){
		this.perFacet = perFacet;
	}

	public List<Object> getPerFacet(){
		return perFacet;
	}

	public void setEtaId(int etaId){
		this.etaId = etaId;
	}

	public int getEtaId(){
		return etaId;
	}

	public void setSubsection(String subsection){
		this.subsection = subsection;
	}

	public String getSubsection(){
		return subsection;
	}

	public void setOrgFacet(List<Object> orgFacet){
		this.orgFacet = orgFacet;
	}

	public List<Object> getOrgFacet(){
		return orgFacet;
	}

	public void setNytdsection(String nytdsection){
		this.nytdsection = nytdsection;
	}

	public String getNytdsection(){
		return nytdsection;
	}

	public void setColumn(Object column){
		this.column = column;
	}

	public Object getColumn(){
		return column;
	}

	public void setSection(String section){
		this.section = section;
	}

	public String getSection(){
		return section;
	}

	public void setAssetId(long assetId){
		this.assetId = assetId;
	}

	public long getAssetId(){
		return assetId;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setJsonMemberAbstract(String jsonMemberAbstract){
		this.jsonMemberAbstract = jsonMemberAbstract;
	}

	public String getJsonMemberAbstract(){
		return jsonMemberAbstract;
	}

	public void setMedia(List<MediaItem> media){
		this.media = media;
	}

	public List<MediaItem> getMedia(){
		return media;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setDesFacet(List<String> desFacet){
		this.desFacet = desFacet;
	}

	public List<String> getDesFacet(){
		return desFacet;
	}

	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAdxKeywords(String adxKeywords){
		this.adxKeywords = adxKeywords;
	}

	public String getAdxKeywords(){
		return adxKeywords;
	}

	public void setGeoFacet(List<String> geoFacet){
		this.geoFacet = geoFacet;
	}

	public List<String> getGeoFacet(){
		return geoFacet;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	public String getPublishedDate(){
		return publishedDate;
	}

	public void setUpdated(String updated){
		this.updated = updated;
	}

	public String getUpdated(){
		return updated;
	}

	public void setByline(String byline){
		this.byline = byline;
	}

	public String getByline(){
		return byline;
	}
}