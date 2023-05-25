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

import com.ssafy.ssafit.model.dto.SearchCondition;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(tags = "비디오 컨트롤러")
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@GetMapping("/video")
	public ResponseEntity<?> getVideoList(SearchCondition searchCondition){
		
		List<Video> list = videoService.selectAll(searchCondition);
		if(list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/video/{id}")
	public ResponseEntity<?> getVideoOne(@PathVariable int id){
		
		Video video = videoService.selectOne(id);
		
		if(video == null) {
			return new ResponseEntity<String>("해당 번호의 게시글이 없습니다.", HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Video>(video, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/video")
	public ResponseEntity<?> insertVideo(Video video){
//		
//		if(session.getAttribute("loginUser") == null) {
//			return new ResponseEntity<String>("please login", HttpStatus.BAD_REQUEST);
//		}
		
		int result = videoService.insertVideo(video);
		
		if(result > 0) {
			return new ResponseEntity<Video>(video, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/video/{id}")
	public ResponseEntity<?> deleteVideo(@PathVariable int id){
		
//		User loginUser = (User)session.getAttribute("loginUser");
		
		Video video = videoService.selectOne(id);
		
//		if(loginUser == null || !loginUser.getUserId().equals(video.getUserId())) {
//			return new ResponseEntity<String>("please login!", HttpStatus.BAD_REQUEST);
//		}
		
		if(video == null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}else {
			
			int result = videoService.deleteVideo(id);
			if(result > 0) {
				return new ResponseEntity<Void>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
			
		}
		
	}
	
	@PutMapping("/video")
	public ResponseEntity<?> updateVideo(Video video){
		
//		User loginUser = (User)session.getAttribute("loginUser");
		
//		if(loginUser == null || !loginUser.getUserId().equals(video.getUserId())) {
//		return new ResponseEntity<String>("please login!", HttpStatus.BAD_REQUEST);
//	}
		
		int result = videoService.updateVideo(video);
		
		if(result > 0) {
			return new ResponseEntity<Video>(video, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
