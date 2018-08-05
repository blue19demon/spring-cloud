package com.zimadai.userweb.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zimadai.movie.response.MovieResponse;

@FeignClient(value = "movie-service")
@RequestMapping(value = "/api-movie")
public interface MovieWSFeign {
	@RequestMapping(value = "/movie/deleteWS", method = RequestMethod.GET)
	public int deleteMovie(@RequestParam(value = "id") Integer id);

	@RequestMapping(value = "/movie/findMovieByPageWS", method = RequestMethod.GET)
	public List<MovieResponse> findMovieByPage(@RequestParam(value = "pageNow")Integer pageNow,
			@RequestParam(value = "pageSize")Integer pageSize);
}
