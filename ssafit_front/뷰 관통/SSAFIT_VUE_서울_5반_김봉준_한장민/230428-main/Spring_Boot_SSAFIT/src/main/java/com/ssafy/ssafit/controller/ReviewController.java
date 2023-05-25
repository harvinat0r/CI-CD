package com.ssafy.ssafit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.ReviewService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(tags = "리뷰 컨트롤러")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/review/{videoId}")
	public ResponseEntity<?> getReviewList(@PathVariable int videoId){
		
		List<Review> list = reviewService.selectAll(videoId);
		
		if(list.size() == 0) {
			return new ResponseEntity<String>("NO CONTENT", HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/review")
	public ResponseEntity<?> insertReview(Review review){
		
		int result = reviewService.insertReview(review);
		
		if(result > 0) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("something wrong", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/review/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable int reviewId){
		
//		User loginUser = (User) session.getAttribute("loginUser");
		
		Review review = reviewService.selectOneReview(reviewId);
		
//		if(loginUser == null || !review.getUserId().equals(loginUser.getUserId())) {
//			return new ResponseEntity<String>("something wrong", HttpStatus.BAD_REQUEST);
//		}
		
//		if(review == null) {
//			return new ResponseEntity<String>("something wrong", HttpStatus.BAD_REQUEST);
//		}
		
		int result = reviewService.deleteReview(reviewId);
		
		if(result > 0) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("something wrong", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/review")
	public ResponseEntity<?> updateReview(Review review){
		
//		User loginUser = (User) session.getAttribute("loginUser");
		
		int result = reviewService.updateReview(review);
		
//		if(loginUser == null || !review.getUserId().equals(loginUser.getUserId())) {
//		return new ResponseEntity<String>("something wrong", HttpStatus.BAD_REQUEST);
//	}
		
		if(result > 0) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("something wrong", HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	

}
