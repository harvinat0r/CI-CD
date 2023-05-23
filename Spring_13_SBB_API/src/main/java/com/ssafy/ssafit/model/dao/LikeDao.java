package com.ssafy.ssafit.model.dao;

import java.util.Map;

import com.ssafy.ssafit.model.dto.Like;

public interface LikeDao {

	///////////////////////////////////////////////////////
	// 게시판에 대한 좋아요 처리
	///////////////////////////////////////////////////////
	Like selectLikeByArticle(Map<String, Object> map);

	int insertLikeByArticle(Map<String, Object> map);
	
	int updateLikeByArticle(Map<String, Object> map);

	int deleteLikeByArticle(Like result);
	
	void increaseLikeByArticle(int article_id);

	void increaseUnLikeByArticle(int article_id);

	void reduceLikeByArticle(int article_id);
	
	void reduceUnLikeByArticle(int article_id);

	///////////////////////////////////////////////////////
	// 운동에 대한 좋아요 처리
	///////////////////////////////////////////////////////
	Like selectLikeByExercise(Map<String, Object> map);

	int insertLikeByExercise(Map<String, Object> map);
	
	int deleteLikeByExercise(Like result);
	
	void increaseLikeByExercise(String exercise_name);

	void reduceLikeByExercise(String exercise_name);

	///////////////////////////////////////////////////////
	// 프로그램에 대한 좋아요 처리
	///////////////////////////////////////////////////////
	
	Like selectLikeByProgram(Map<String, Object> map);

	int insertLikeByProgram(Map<String, Object> map);
	
	int updateLikeByProgram(Map<String, Object> map);
	
	int deleteLikeByProgram(Like result);
	
	void increaseLikeByProgram(int program_id);

	void increaseUnLikeByProgram(int program_id);

	void reduceLikeByProgram(int program_id);
	
	void reduceUnLikeByProgram(int program_id);

	///////////////////////////////////////////////////////
	// 댓글에 대한 좋아요 처리
	///////////////////////////////////////////////////////
	
	Like selectLikeByReview(Map<String, Object> map);

	int insertLikeByReview(Map<String, Object> map);
	
	int deleteLikeByReview(Like result);
	
	void increaseLikeByReview(int review_id);

	void reduceLikeByReview(int review_id);
}
