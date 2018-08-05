package com.zimadai.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zimadai.cloud.bean.Movie;
import com.zimadai.cloud.service.MovieService;
import com.zimadai.cloud.ws.MovieWSLocalService;
import com.zimadai.movie.response.MovieResponse;


/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    
    @Autowired
    private MovieWSLocalService movieWSLocalService;
    
    
    @ResponseBody
    @RequestMapping(value = "/deleteWS", produces = {"application/json;charset=UTF-8"})
    public int deleteMovieWS(Integer id){
        return movieWSLocalService.deleteMovie(id);
    }

    @ResponseBody
    @RequestMapping(value = "/findMovieByPageWS", produces = {"application/json;charset=UTF-8"})
    public List<MovieResponse> findMovieByPageWS(Integer pageNow, Integer pageSize){
        return movieWSLocalService.findMovieByPage(pageNow, pageSize);
    }

    
    
    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(Movie movie){
        return movieService.addMovie(movie);
    }

    @ResponseBody
    @RequestMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    public Object findAllMovie(){
        return movieService.findAllMovie();
    }
}