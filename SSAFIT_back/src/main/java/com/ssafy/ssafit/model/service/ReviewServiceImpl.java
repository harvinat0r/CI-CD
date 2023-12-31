package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ReviewDao;
import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.SearchCondition;

@Service
public class ReviewServiceImpl implements ReviewService {


	private ReviewDao reviewDao;

	@Autowired
	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	public List<Review> getReviewList() {
		return reviewDao.selectAll();
	}

	@Override
	public int writeReview(Review review) {
		// 프로그램에 대한 리뷰
		if(review.getProgram_id() > 0) return reviewDao.insertReviewProgram(review);
		// 리뷰에 대한 리뷰
		else if(review.getParent_id() > 0) return reviewDao.insertReviewParent(review);
		// 게시판에 대한 리뷰
		else return reviewDao.insertReviewArticle(review);
	}

	@Override
	public int removeReview(int review_id) {
		// 리뷰 삭제해
		return reviewDao.deleteReview(review_id);
	}

	@Override
	public int modifyReview(Review review) {
		// 리뷰  수정해
		return reviewDao.updateReview(review);
	}

	@Override
	public List<Review> search(SearchCondition condition) {
		return reviewDao.search(condition);
	}

	// 대댓글 가져와
	@Override
	public List<Review> getReviewListByParent(int parent_id) {
		return reviewDao.selectByParent(parent_id);
	}

	// 프로그램 댓글 가져와
	@Override
	public List<Review> getReviewListByProgram(int program_id) {
		return reviewDao.selectByProgram(program_id);
	}

	// 게시판 댓글 가져와
	@Override
	public List<Review> getReviewListByArticle(int article_id) {
		return reviewDao.selectByArticle(article_id);
	}
}

