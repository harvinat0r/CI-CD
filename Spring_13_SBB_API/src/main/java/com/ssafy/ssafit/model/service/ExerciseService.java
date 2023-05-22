package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Exercise;

public interface ExerciseService {
	
	// 운동 부위별 영상
	public List<Exercise> bySearch();
	
	// 조회수 많은 영상
	public List<Exercise> byLike();
}
