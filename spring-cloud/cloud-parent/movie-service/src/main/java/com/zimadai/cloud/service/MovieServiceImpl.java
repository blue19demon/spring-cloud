package com.zimadai.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zimadai.cloud.bean.Movie;
import com.zimadai.cloud.mapper.MovieMapper;
import com.zimadai.movie.response.MovieResponse;

@Service(value = "movieService")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;//这里会报错，但是并不会影响

    @Override
    public int addMovie(Movie movie) {
        return movieMapper.insertSelective(movie);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<Movie> findAllMovie() {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        //PageHelper.startPage(pageNum, pageSize);
        return movieMapper.selectAll();
    }

	@Override
	public int deleteMovie(Integer id) {
		return movieMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<MovieResponse> findMovieByPage(Integer start, Integer pageSize) {
		return movieMapper.findMovieByPage( start,  pageSize);
	}
}