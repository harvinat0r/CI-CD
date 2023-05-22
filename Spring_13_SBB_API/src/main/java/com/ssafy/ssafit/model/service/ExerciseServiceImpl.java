package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ExerciseDao;
import com.ssafy.ssafit.model.dto.Exercise;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	private ExerciseDao exerciseDao;
	
	@Autowired
	public void setReviewDao(ExerciseDao exerciseDao) {
		this.exerciseDao = exerciseDao;
	}
	@Override
	public List<Exercise> bySearch() {
		return exerciseDao.bysearch();
	}
	@Override
	public List<Exercise> byLike() {
		// TODO Auto-generated method stub
		return exerciseDao.byLike();
	}
	
	
}
