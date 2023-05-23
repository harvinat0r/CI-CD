package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.SearchCondition;

public interface ReviewDao {
	
	
	
	// 대댓글 전체 조회	
	public List<Review> selectByParent(int parent_id);

	// 프로그램에 대한 댓글 전체 조회
	public List<Review> selectByProgram(int program_id);
	
	// 게시판에 대한 댓글 전체 조회
	public List<Review> selectByArticle(int article_id);
	
	
	
	
	
	
	
	
	
	// 전체 리뷰들을 몽땅 들고 오쎄용
	public List<Review> selectAll();	

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

}
