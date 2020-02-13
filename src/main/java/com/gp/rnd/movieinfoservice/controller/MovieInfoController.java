package com.gp.rnd.movieinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gp.rnd.movieinfoservice.config.MovieDBConfig;
import com.gp.rnd.movieinfoservice.entity.Movie;
import com.gp.rnd.movieinfoservice.entity.MovieSummary;

@RestController
@RequestMapping("/movies")
@RefreshScope
public class MovieInfoController {
	
	
//	@Value("${api.key}")
//	private String apiKey;
//	
//	@Value("${api.baseurl}")
//	private String baseUrl;
	
	@Value("${app.description}")
	private String welcomeMessage;
	
	@Autowired
	private MovieDBConfig MovieDBConfig;
	
	@Autowired
	private RestTemplate restTemplate;
	

	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId){
		
		MovieSummary summary = 
				restTemplate.getForObject(MovieDBConfig.getBaseUrl()+movieId+"?api_key="+MovieDBConfig.getKey(),MovieSummary.class);
		
		Movie movie = new Movie(movieId,summary.getTitle(),summary.getOverview());
		
		return movie;	
		
	}
	
	@GetMapping("/greeting")
	public String greetUser() {
		return welcomeMessage;
	}
	
	@GetMapping("/test-api")
	public String welcomeMessage() {
		return "Hello World! Deployed from pipeline";
	}
}
