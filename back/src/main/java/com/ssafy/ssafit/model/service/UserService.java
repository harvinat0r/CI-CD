package com.ssafy.ssafit.model.service;

import java.util.Date;
import java.util.List;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	public List<User> getUserList();
	public User selectOne(String id);
	public int signup(User user);
	public User login(String id, String password);
	public User deleteUser(User user);
	public int modifyUser(User user);
	public int checkPassword(User user);
	public void findId(String user_name, Date birth, String question_1, String question_2);
	public void findPassword(String user_id, String user_name, Date birth, String question_1, String question_2);
}
