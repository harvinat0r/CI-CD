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
}
