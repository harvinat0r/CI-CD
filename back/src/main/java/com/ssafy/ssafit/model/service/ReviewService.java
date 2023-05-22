package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.SearchCondition;

//사용자 친화적으로
public interface ReviewService {
	//게시글 전체 조회
	public List<Review> getReviewList();
	
	//게시글 작성
	public int writeReview(Review review);
	
	//게시글 삭제 
	public int removeReview(int review_id);
	
	//게시글 수정
	public int modifyReview(Review review);
	
	//검색 버튼을 눌렀을 때 처리하기 위한 메서드
	public List<Review> search(SearchCondition condition);

	// 대댓글 전체 조회
	public List<Review> getReviewListByParent(int parent_id);
	
}
