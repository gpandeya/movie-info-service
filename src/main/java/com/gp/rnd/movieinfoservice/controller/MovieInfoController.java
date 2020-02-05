package com.gp.rnd.movieinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gp.rnd.movieinfoservice.entity.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId){
		if(("110").equalsIgnoreCase(movieId)) {
			return new Movie(movieId,"Lion king");
		}
		
		if(("120").equalsIgnoreCase(movieId)) {
			return new Movie(movieId,"Toy Story");
		}
		if(("130").equalsIgnoreCase(movieId)) {
			return new Movie(movieId,"Frozen");
		}
		else
			return new Movie(movieId,"Test Movie");
		
	}
}
