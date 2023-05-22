package com.ssafy.ssafit.model.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dao.ExerciseDao;
import com.ssafy.ssafit.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}


	@Override
	public int signup(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User login(String id, String password) {
		User tmp = userDao.selectOne(id);
		//다음 중  tmp에 들어갈 수있는 것들은 ? 
		//1. 아이디가 일치하는 유저의 정보
		//2. null
		if(tmp != null && tmp.getUser_password().equals(password))
			return tmp;
		return null;
	}
	
	@Override
	public User deleteUser(User user) {
		User u = userDao.selectOne(user.getUser_id());
		if(u != null && u.getUser_password().contentEquals(user.getUser_password()))
			return u;
		return null;
	}
	
	@Override
	public int modifyUser(User user) {		
		return userDao.updateUser(user);
	}
	@Override
	public void findId(String user_name, Date birth, String question_1, String question_2) {
//		User u = userDao.selectOne()
	}
	@Override
	public void findPassword(String user_id, String user_name, Date birth, String question_1, String question_2) {
		
	}
	
	@Override
	public int checkPassword(User user) {
		return 0;
	}
	@Override
	public User selectOne(String id) {
		
		return null;
	}

}
