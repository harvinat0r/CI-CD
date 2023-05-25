package com.ssafy.ssafit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	
	// 회원 가입한 사용자들의 리스트 반환
	public List<User> selectAll();
	
	// 회원 가입
	public int insertUser(User user);
	
	// 회원탈퇴
	public void deleteUser(User user);
	
	// 회원정보 수정
	public void updateUser(User user);
	
	// 'id'가 일치하는 회원 반환  (primary key로) 
	public User selectOne(String id);

	// `id` 찾기
	public User findId(Map<String, Object> map);

	// `랭킹 조회 
	
//	public int checkPassword(User user);
}