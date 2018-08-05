package com.zimadai.movie.ws;

import java.util.List;

import com.zimadai.movie.response.MovieResponse;

public interface MovieWSService {

	public int deleteMovie(Integer id);
	
	public List<MovieResponse> findMovieByPage(Integer pageNow,Integer pageSize);
}
