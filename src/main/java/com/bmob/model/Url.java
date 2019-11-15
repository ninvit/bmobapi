package com.bmob.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "urls")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Url {
	private long id;
	private String alias;
	private String longUrl;
	private String shortUrl;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	@Override
	public String toString() {
		return "Url [id=" + id + ", alias=" + alias + ", longUrl=" + longUrl + ", shortUrl=" + shortUrl + "]";
	}
	public Url(long id, String alias, String longUrl, String shortUrl) {
		super();
		this.id = id;
		this.alias = alias;
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
	}
	public Url() {
	}



}
