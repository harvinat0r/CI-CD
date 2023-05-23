package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ExerciseDao;
import com.ssafy.ssafit.model.dto.Exercise;
import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.User;

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
	
	// 운동에 대한 좋아요 처리
	@Override
	public int like(User user, String exercise_name) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user.getUser_id());
		map.put("exercise_name", exercise_name);
		Like result = exerciseDao.selectLike(map);
		
		if(result == null) {
			exerciseDao.increaseLike(exercise_name);
			return exerciseDao.insertLike(map);
		}
		
		exerciseDao.reduceLike(exercise_name);
		return exerciseDao.deleteLike(result);
	}
	
}
