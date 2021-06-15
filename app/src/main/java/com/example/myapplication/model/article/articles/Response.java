package com.example.myapplication.model.article.articles;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("docs")
	private List<DocsItem> docs;

	@SerializedName("meta")
	private Meta meta;

	public void setDocs(List<DocsItem> docs){
		this.docs = docs;
	}

	public List<DocsItem> getDocs(){
		return docs;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}
}