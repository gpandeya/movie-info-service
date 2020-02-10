package com.gp.rnd.movieinfoservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("moviedb")
public class MovieDBConfig {

	private String baseUrl;

	private String key;
	
	public MovieDBConfig() {
		
	}
	
	public MovieDBConfig(String baseUrl, String key) {
		super();
		this.baseUrl = baseUrl;
		this.key = key;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "MovieDBConfig [baseUrl=" + baseUrl + ", key=" + key + "]";
	}

	
}
