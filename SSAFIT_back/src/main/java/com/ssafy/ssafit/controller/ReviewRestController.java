package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController // 전체 ResponseBody 해줘
@RequestMapping("/review")
@Api(tags = "review-rest-controller")
@CrossOrigin("*")
public class ReviewRestController {
	
	@Autowired
	private ReviewService reviewService;

	// 전체 목록 가져와.
	@ApiOperation(value="리뷰 전체 조회", notes = "리뷰 다 가져왕")
	@GetMapping("/list")
	public ResponseEntity<?> list(){		
		List<Review> list = reviewService.getReviewList();  // 전체 조회 		
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}
	
	// 대댓글 가져와. 날짜 기준 내림차순
	@ApiOperation(value="대댓글", notes = "댓글에 대한 댓글들 가져와")
	@GetMapping("/parent/{review_id}")
	public ResponseEntity<?> listByParent(@PathVariable int parent_id){		
		List<Review> list = reviewService.getReviewListByParent	(parent_id);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}
	
	// 프로그램 댓글 가져와. 날짜 기준 내림차순
	@ApiOperation(value="프로그램 댓글", notes = "프로그램에 대한 댓글들 가져와")
	@GetMapping("/program/{program_id}")
	public ResponseEntity<?> listByProgram(@PathVariable int program_id){		
		List<Review> list = reviewService.getReviewListByProgram(program_id);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}
	
	// 게시판 댓글 가져와. 날짜 기준 내림차순
	@ApiOperation(value="게시판 댓글", notes = "게시판에 대한 댓글들 가져와")
	@GetMapping("/article/{article_id}")
	public ResponseEntity<?> listByArticle(@PathVariable int article_id){		
		List<Review> list = reviewService.getReviewListByArticle(article_id);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}
	
	// 등록
	// 로그인 여부에 대한 확인이 없음 => ★뷰에서 로그인했을 때만 등록 버튼을 보이게 구현 필요★
	@ApiOperation(value="리뷰 등록", notes = "리뷰 등록하자")
	@PostMapping("/write")
	public ResponseEntity<?> write(Review review){
		System.out.println(review);
		int result = reviewService.writeReview(review);
		
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	// 삭제
	// 로그인 여부에 대한 확인이 없음 => ★뷰에서 로그인했을 때만 삭제 버튼을 보이게 구현 필요★
	@ApiOperation(value="리뷰 삭제", notes = "리뷰를 삭제하자")
	@DeleteMapping("/delete/{review_id}")
	public ResponseEntity<?> delete(@PathVariable int review_id){
		int result = reviewService.removeReview(review_id);
		
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	// 수정
	// 로그인 여부에 대한 확인이 없음 => ★뷰에서 로그인했을 때만 수정 버튼을 보이게 구현 필요★
	@ApiIgnore
	@ApiOperation(value="리뷰 수정", notes = "리뷰 수정하자")
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Review review){
		int result = reviewService.modifyReview(review);
		
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Review>(review, HttpStatus.OK);
	}	
	
}
