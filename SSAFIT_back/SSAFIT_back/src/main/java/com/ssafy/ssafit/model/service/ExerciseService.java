package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Exercise;
import com.ssafy.ssafit.model.dto.User;

public interface ExerciseService {
	
	// 모든 운동 조회
	public List<Exercise> selectAll();
	
	// 운동 cnt 증가
	public void increaseSearch(String exercise_name);
	
	// 운동 부위별 영상
	public List<Exercise> bySearch();
	
	// 조회수 많은 영상
	public List<Exercise> byLike();
}
