package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Exercise;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.ExerciseService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/exercise")
public class ExerciseRestController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@GetMapping("/search")
	@ApiOperation(value="운동 검색 수 증가", notes="운동이 검색어에 포함되면 운동 검색 수 증가")
	public ResponseEntity<?> search(String str) {
		String searchStr = str.replace(" ", "");
		List<Exercise> list = exerciseService.selectAll();
		
		for(Exercise exercise : list) {
			if(searchStr.contains(exercise.getExercise_name())) exerciseService.increaseSearch(exercise.getExercise_name());
		}
		// 해당하는 운동이 있을 때
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/bySearch")
	@ApiOperation(value="검색을 기준으로 내림차순 정렬하여 운동 조회", notes="검색을 기준으로 내림차순 정렬하여 10개 운동 조회")
	public ResponseEntity<?> bySearch() {
		List<Exercise> list = exerciseService.bySearch();
		
		// 운동영상이 1개도 없을 때
		if(list == null || list.size() == 0) return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		// 해당하는 운동이 있을 때
		return new ResponseEntity<List<Exercise>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/byLike")
	@ApiOperation(value="좋아요를 기준으로 내림차순 정렬하여 운동 조회", notes="좋아요를 기준으로 내림차순 정렬하여 10개 운동 조회")
	public ResponseEntity<?> byLike() {
		List<Exercise> list = exerciseService.byLike();
		
		// 운동영상이 1개도 없을 때
		if(list == null || list.size() == 0) return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				
		// 해당하는 운동이 있을 때
		return new ResponseEntity<List<Exercise>>(list, HttpStatus.OK);
	}
}
