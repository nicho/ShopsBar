package com.nicho.shops.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

//JPA标识
@Entity
@Table(name = "shops_advertisement")
public class Advertisement extends IdEntity {
 
	private String title;
	private String description;
	private String backgroundImageUrl;
	private String openBtnName;
	private String openUrl;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBackgroundImageUrl() {
		return backgroundImageUrl;
	}
	public void setBackgroundImageUrl(String backgroundImageUrl) {
		this.backgroundImageUrl = backgroundImageUrl;
	}
	public String getOpenUrl() {
		return openUrl;
	}
	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}
	public String getOpenBtnName() {
		return openBtnName;
	}
	public void setOpenBtnName(String openBtnName) {
		this.openBtnName = openBtnName;
	}
	
}
