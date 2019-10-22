package com.pking.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.pking.common.RedisService;
import com.pking.entity.MoUser;

@Service
public class UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
    private RedisService redisService ;
	public List<MoUser> getListFromDB() {
		return jdbcTemplate.query("select * from person", new RowMapper<MoUser>() {
			@Override
			public MoUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				return MoUser.builder()
						.id(rs.getInt("id"))
						.first(rs.getString("first"))
						.last(rs.getString("last"))
						.dateofbirth(rs.getDate("dateofbirth"))
						.placeofbirth(rs.getString("placeofbirth"))
						.build();
			}
		});
	}
	
	public String set2Redis(String key,String value) {
		return String.valueOf(redisService.set(key,value));
	}
	
	public String getFromRedis(String key) {
		return String.valueOf(redisService.get(key));
	}
}
