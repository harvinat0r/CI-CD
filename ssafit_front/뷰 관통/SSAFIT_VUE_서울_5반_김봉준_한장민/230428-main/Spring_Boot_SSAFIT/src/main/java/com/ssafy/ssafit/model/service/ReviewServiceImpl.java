package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.ReviewDao;
import com.ssafy.ssafit.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public List<Review> selectAll(int videoId) {
		return reviewDao.selectAll(videoId);
	}

	@Transactional
	@Override
	public int insertReview(Review review) {
		return reviewDao.insertReview(review);
	}

	@Transactional
	@Override
	public int deleteReview(int reviewId) {
		return reviewDao.deleteReview(reviewId);
	}

	@Transactional
	@Override
	public int updateReview(Review review) {
		return reviewDao.updateReview(review);
	}

	@Override
	public Review selectOneReview(int reviewId) {
		return null;
	}

}
