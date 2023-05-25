package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewService {
	
	// 해당 비디오의 리뷰 가져오기
		public List<Review> selectAll(int videoId);
		
		// 리뷰 하나 가져오기(비교용도)
		public Review selectOneReview(int reviewId);
		
		// 리뷰작성
		public int insertReview(Review review);
		
		// 리뷰삭제
		public int deleteReview(int reviewId);
		
		// 리뷰수정
		public int updateReview(Review review);

}
