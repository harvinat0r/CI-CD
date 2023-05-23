package com.ssafy.ssafit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.LikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController // 전체 ResponseBody 해줘
@RequestMapping("/like")
@Api(tags = "like-rest-controller")
@CrossOrigin("*")
public class LikeRestController {
	
	@Autowired
	private LikeService likeService;
	
	// 게시판 좋아요
	@ApiOperation(value="게시판 좋아요", notes = "게시판 좋아요 및 좋아요 취소, 싫어요 및 싫어요 취소")
	@GetMapping("/article/{article_id}")
	public ResponseEntity<?> likeArticle(@RequestBody User user,@PathVariable int article_id, int like_property){
		int result = likeService.likeArticle(user, article_id, like_property);
				
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	// 운동 좋아요
	@ApiOperation(value="운동 좋아요", notes = "운동 좋아요 및 좋아요 취소")
	@GetMapping("/exercise/{exercise_name}")
	public ResponseEntity<?> likeExercise(@RequestBody User user,@PathVariable String exercise_name){
		int result = likeService.likeExercise(user, exercise_name);
				
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	// 프로그램 좋아요
	@ApiOperation(value="프로그램 좋아요", notes = "프로그램 좋아요 및 좋아요 취소, 싫어요 및 싫어요 취소")
	@GetMapping("/program/{program_id}")
	public ResponseEntity<?> likeProgram(User user,@PathVariable int program_id, int like_property){
		int result = likeService.likeProgram(user, program_id, like_property);
				
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	// 댓글 좋아요
	@ApiOperation(value="댓글 좋아요", notes = "댓글 좋아요 및 좋아요 취소")
	@GetMapping("/review/{review_id}")
	public ResponseEntity<?> likeReview(@RequestBody User user,@PathVariable int review_id){
		int result = likeService.likeReview(user, review_id);
			
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
