package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
//	public List<User> getUserList();
	public int signup(User user);
	public User login(String id, String password);
	public void deleteUser(User user);
	public void modifyUser(User user);
	public User checkPassword(User user, String input_password);
//	public void findId(String user_name, Date birth, String question_1, String question_2);
//	public void findPassword(String user_id, String user_name, Date birth, String question_1, String question_2);
	public User viewProfile(User user);
	public List<User> totalRanking();
}
