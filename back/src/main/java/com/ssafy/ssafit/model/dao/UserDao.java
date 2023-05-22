package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	
	// 회원 가입한 사용자들의 리스트 반환
	public List<User> selectAll();
	
	// 회원 가입
	public int insertUser(User user);
	
	// 회원탈퇴
	public int deleteUser(User user);
	
	// 회원정보 수정
	public int updateUser(User user);
	
	// 'id'가 일치하는 회원 반환 
	public User selectOne(String id);
}