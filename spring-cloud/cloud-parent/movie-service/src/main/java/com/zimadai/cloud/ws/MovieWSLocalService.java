package com.zimadai.cloud.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zimadai.cloud.service.MovieService;
import com.zimadai.movie.response.MovieResponse;
import com.zimadai.movie.ws.MovieWSService;

/**
 * @author Administrator
 *
 */
@Service("movieWSLocalService")
public class MovieWSLocalService implements MovieWSService {
	@Autowired
	private MovieService movieService;
	@Override
	public int deleteMovie(Integer id) {
		return movieService.deleteMovie(id);
	}

	@Override
	public List<MovieResponse> findMovieByPage(Integer pageNow, Integer pageSize) {
		Integer start=(pageNow-1)*pageSize+1;
		return movieService.findMovieByPage(start,pageSize);
	}

}
