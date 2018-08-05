package com.zimadai.cloud.service;

import java.util.List;

import com.zimadai.cloud.bean.Movie;
import com.zimadai.movie.response.MovieResponse;

public interface MovieService {

    int addMovie(Movie movie);

    List<Movie> findAllMovie();

	int deleteMovie(Integer id);

	List<MovieResponse> findMovieByPage(Integer start, Integer pageSize);
}
