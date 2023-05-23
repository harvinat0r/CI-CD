package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Exercise;
import com.ssafy.ssafit.model.dto.User;

public interface ExerciseService {
	
	// 운동 부위별 영상
	public List<Exercise> bySearch();
	
	// 조회수 많은 영상
	public List<Exercise> byLike();

	// 운동 좋아요
	public int like(User user, String exercise_name);
}
