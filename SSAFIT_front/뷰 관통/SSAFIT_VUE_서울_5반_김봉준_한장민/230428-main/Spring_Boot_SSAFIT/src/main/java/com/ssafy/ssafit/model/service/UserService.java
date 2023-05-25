package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	
	int insertUser(User user);
	
	User searchById(String id);

}
