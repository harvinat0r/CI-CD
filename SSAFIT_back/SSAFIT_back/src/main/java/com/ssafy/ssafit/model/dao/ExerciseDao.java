package com.ssafy.ssafit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.Exercise;
import com.ssafy.ssafit.model.dto.Like;

public interface ExerciseDao {
	
	// 모든 운동 조회
	public List<Exercise> selectAll();
	
	// 운동 검색 cnt 증가
	public void increaseSearch(String exercise_name);
	
	// 검색수 기준으로 내림차순 정렬 후 조회
	public List<Exercise> bySearch();
		
	// 좋아요 기준으로 내림차순 정렬 후 조회
	public List<Exercise> byLike();
}
