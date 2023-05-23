package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

//	@Override
//	public List<User> getUserList() {
//		return userDao.selectAll();
//	}

	@Override
	public int signup(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User login(String id, String password) {
		User tmp = userDao.selectOne(id);
		// 다음 중 tmp에 들어갈 수있는 것들은 ?
		// 1. 아이디가 일치하는 유저의 정보
		// 2. null
		if (tmp != null && tmp.getUser_password().equals(password))
			return tmp;
		else
			return null;
	}

	@Override
	public User checkPassword(User user, String input_password) { // 암호화 x
		if (user.getUser_password().equals(input_password))
			return user;
		else
			return null;
	}

	@Transactional
	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	@Transactional
	@Override
	public void modifyUser(User user) {
		userDao.updateUser(user);
	}
	
	@Override
	public User viewProfile(User user) {
		User u = userDao.selectOne(user.getUser_id());
		return u;
	}

	@Override
	public List<User> totalRanking() {
		return userDao.selectAll();
	}


//	@Override
//	public void findId(String user_name, Date birth, String question_1, String question_2) {
//		Map<String, Object> map = new HashMap<>();
//		if (question_1 == null) {
//			map.put("user_name", user_name);
//			map.put("birth", birth);
//			map.put("question_2", question_2);
//		}
//		else {
//			map.put("user_name", user_name);
//			map.put("birth", birth);
//			map.put("question_2", question_1);
//		}
//		User u = userDao.findId(map);
//	}

//	@Override
//	public void findPassword(String user_id, String user_name, Date birth, String question_1, String question_2) {
//
//	}



}
