package com.ssafy.ssafit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.SearchCondition;

public interface ReviewDao {
	// 대댓글 전체 조회
	public List<Review> selectByParent(int parent_id);

	// 전체 리뷰들을 몽땅 들고 오쎄용
	public List<Review> selectAll();
	
	// 프로그램에 대한 댓글 전체 조회
	public List<Review> selectByProgram(int program_id);
	
	// 게시판에 대한 댓글 전체 조회
	public List<Review> selectByArticle(int article_id);

	// 리뷰 등록
	public int insertReviewProgram(Review review);
	public int insertReviewParent(Review review);
	public int insertReviewArticle(Review review);

	// 리뷰 삭제
	public int deleteReview(int review_id);

	// 리뷰 수정
	public int updateReview(Review review);

	// 리뷰 증가
	public void updateViewCnt(int review_id);
	
	//검색기능
	public List<Review> search(SearchCondition condition);

	// 사용자가 특정 리뷰에 좋아요를 했는지 Like를 가져옴
	public Like selectLikeByuserFromReview(Map<String, Object> map);

	// 사용자가 특정 리뷰에 좋아요를 누름
	public int insertLikeToReview(Map<String, Object> map);

	// 사용자가 특정 리뷰에 좋아요를 취소
	public int deleteLikeFromReview(Like result);

	// 사용자가 특정 프로그램에 좋아요 혹은 싫어요를 했는지 Like를 가져옴
	public Like selectLikeByuserFromProgram(Map<String, Object> map);

	// 사용자가 특정 프로그램에 좋아요 혹은 싫어요를 입력
	public int insertLikeToProgram(Map<String, Object> map);

	// 사용자가 특정 프로그램에 좋아요 혹은 싫어요를 변경함
	public int updateLikeFromProgram(Map<String, Object> map);

	// 사용자가 특정 프로그램에 좋아요 혹은 싫어요를 취소함
	public int deleteLikeFromProgram(Like result);

	
}
