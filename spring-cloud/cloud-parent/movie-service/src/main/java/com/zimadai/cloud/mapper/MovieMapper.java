package com.zimadai.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zimadai.cloud.bean.Movie;
import com.zimadai.movie.response.MovieResponse;

public interface MovieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

	List<Movie> selectAll();

	List<MovieResponse> findMovieByPage(@Param("start")Integer start,@Param("pageSize") Integer pageSize);
}