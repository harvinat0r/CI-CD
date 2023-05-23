package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.User;

public interface LikeService {

	// 게시판 좋아요
	int likeArticle(User user, int article_id, int like_property);

	// 운동 좋아요
	int likeExercise(User user, String exercise_name);

	// 프로그램 좋아요
	int likeProgram(User user, int program_id, int like_property);

	// 리뷰 좋아요
	int likeReview(User user, int review_id);

}
