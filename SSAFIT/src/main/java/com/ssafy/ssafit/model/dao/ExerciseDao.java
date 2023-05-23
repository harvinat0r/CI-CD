package com.ssafy.ssafit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.Exercise;
import com.ssafy.ssafit.model.dto.Like;

public interface ExerciseDao {
	
	// 검색 기준으로 내림차순 정렬 후 조회
	public List<Exercise> bysearch();
		
	// 검색 기준으로 내림차순 정렬 후 조회
	public List<Exercise> byLike();

	// 좋아요 조회
	public Like selectLike(Map<String, Object> map);

	// 좋아요 추가
	public int insertLike(Map<String, Object> map);
	
	// 좋아요 삭제
	public int deleteLike(Like result);

	// 좋아요 증가
	public void increaseLike(String exercise_name);
		
	// 좋아요 감소 
	public void reduceLike(String exercise_name);

}
