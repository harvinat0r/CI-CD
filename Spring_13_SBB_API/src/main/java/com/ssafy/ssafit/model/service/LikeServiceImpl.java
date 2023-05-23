package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.LikeDao;
import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.User;

@Service
public class LikeServiceImpl implements LikeService {

	private LikeDao likeDao;
	
	@Autowired
	public void setLikeDao(LikeDao likeDao) {
		this.likeDao = likeDao;
	}
	
	// 게시판 좋아요. 싫어요 있음
	@Override
	public int likeArticle(User user, int article_id, int like_property) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user.getUser_id());
		map.put("article_id", article_id);
		map.put("like_property", like_property);
		Like result = likeDao.selectLikeByArticle(map);
			
		if(result == null) {
			if(like_property == 1) likeDao.increaseLikeByArticle(article_id);
			else likeDao.increaseUnLikeByArticle(article_id);
			return likeDao.insertLikeByArticle(map);
		}
		else if(like_property != result.getLike_property()) {
			if(like_property == 1) {
				likeDao.increaseLikeByArticle(article_id);
				likeDao.reduceUnLikeByArticle(article_id);
			}
			else {
				likeDao.reduceLikeByArticle(article_id);
				likeDao.increaseUnLikeByArticle(article_id);
			}
			return likeDao.updateLikeByArticle(map);
		}
		if(like_property == 1) likeDao.reduceLikeByArticle(article_id);
		else likeDao.reduceUnLikeByArticle(article_id);
		return likeDao.deleteLikeByArticle(result);
	}

	// 운동 좋아요.
	@Override
	public int likeExercise(User user, String exercise_name) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user.getUser_id());
		map.put("exercise_name", exercise_name);
		Like result = likeDao.selectLikeByExercise(map);
		
		if(result == null) {
			likeDao.increaseLikeByExercise(exercise_name);
			return likeDao.insertLikeByExercise(map);
		}
		
		likeDao.reduceLikeByExercise(exercise_name);
		return likeDao.deleteLikeByExercise(result);
	}

	// 프로그램 좋아요. 싫어요 있음
	@Override
	public int likeProgram(User user, int program_id, int like_property) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user.getUser_id());
		map.put("program_id", program_id);
		map.put("like_property", like_property);
		Like result = likeDao.selectLikeByProgram(map);
			
		if(result == null) {
			if(like_property == 1) likeDao.increaseLikeByProgram(program_id);
			else likeDao.increaseUnLikeByProgram(program_id);
			return likeDao.insertLikeByProgram(map);
		}
		else if(like_property != result.getLike_property()) {
			if(like_property == 1) {
				likeDao.increaseLikeByProgram(program_id);
				likeDao.reduceUnLikeByProgram(program_id);
			}
			else {
				likeDao.reduceLikeByProgram(program_id);
				likeDao.increaseUnLikeByProgram(program_id);
			}
			return likeDao.updateLikeByProgram(map);
		}
		if(like_property == 1) likeDao.reduceLikeByProgram(program_id);
		else likeDao.reduceUnLikeByProgram(program_id);
		return likeDao.deleteLikeByProgram(result);
	}

	// 댓글 좋아요.
	@Override
	public int likeReview(User user, int review_id) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user.getUser_id());
		map.put("review_id", review_id);
		Like result = likeDao.selectLikeByReview(map);
		
		if(result == null) {
			likeDao.increaseLikeByReview(review_id);
			return likeDao.insertLikeByReview(map);
		}
		
		likeDao.reduceLikeByReview(review_id);
		return likeDao.deleteLikeByReview(result);
	}

}
