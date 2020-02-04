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
		
		return new Movie(movieId,"Test Movie");
		
	}
}
