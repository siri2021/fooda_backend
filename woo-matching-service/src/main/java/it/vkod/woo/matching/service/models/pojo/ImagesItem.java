package it.vkod.woo.matching.service.models.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImagesItem{

	@JsonProperty("date_modified_gmt")
	private String dateModifiedGmt;

	@JsonProperty("date_modified")
	private String dateModified;

	@JsonProperty("src")
	private String src;

	@JsonProperty("date_created")
	private String dateCreated;

	@JsonProperty("name")
	private String name;

	@JsonProperty("alt")
	private String alt;

	@JsonProperty("date_created_gmt")
	private String dateCreatedGmt;

	@JsonProperty("id")
	private int id;

	public void setDateModifiedGmt(String dateModifiedGmt){
		this.dateModifiedGmt = dateModifiedGmt;
	}

	public String getDateModifiedGmt(){
		return dateModifiedGmt;
	}

	public void setDateModified(String dateModified){
		this.dateModified = dateModified;
	}

	public String getDateModified(){
		return dateModified;
	}

	public void setSrc(String src){
		this.src = src;
	}

	public String getSrc(){
		return src;
	}

	public void setDateCreated(String dateCreated){
		this.dateCreated = dateCreated;
	}

	public String getDateCreated(){
		return dateCreated;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAlt(String alt){
		this.alt = alt;
	}

	public String getAlt(){
		return alt;
	}

	public void setDateCreatedGmt(String dateCreatedGmt){
		this.dateCreatedGmt = dateCreatedGmt;
	}

	public String getDateCreatedGmt(){
		return dateCreatedGmt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ImagesItem{" + 
			"date_modified_gmt = '" + dateModifiedGmt + '\'' + 
			",date_modified = '" + dateModified + '\'' + 
			",src = '" + src + '\'' + 
			",date_created = '" + dateCreated + '\'' + 
			",name = '" + name + '\'' + 
			",alt = '" + alt + '\'' + 
			",date_created_gmt = '" + dateCreatedGmt + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}