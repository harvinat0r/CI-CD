package com.ssafy.ssafit.model.dao;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	
	int insertUser(User user);
	
	User searchById(String id);

}
