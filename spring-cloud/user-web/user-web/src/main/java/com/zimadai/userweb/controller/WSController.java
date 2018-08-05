package com.zimadai.userweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zimadai.movie.response.MovieResponse;
import com.zimadai.user.response.UserResponse;
import com.zimadai.userweb.feign.MovieWSFeign;
import com.zimadai.userweb.feign.UserWSFeign;

@RestController
@RequestMapping("/ws")
public class WSController {
	@Autowired
	private UserWSFeign userWSFeign;
	@Autowired
	private MovieWSFeign movieWSFeign;

	@GetMapping("/deleteUser")
	public Integer deleteUser(Integer id) {
		return userWSFeign.deleteUser(id);
	}
	
	@GetMapping("/findUserByPage")
	public List<UserResponse> findUserByPage(Integer pageNow,Integer pageSize) {
		return userWSFeign.findUserByPage(pageNow, pageSize);
	}
	
	@GetMapping("/deleteMovie")
	public Integer deleteMovie(Integer id) {
		return movieWSFeign.deleteMovie(id);
	}
	
	@GetMapping("/findMovieByPage")
	public List<MovieResponse> findMovieByPage(Integer pageNow,Integer pageSize) {
		return movieWSFeign.findMovieByPage(pageNow, pageSize);
	}
}
