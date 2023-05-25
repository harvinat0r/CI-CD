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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Program;
import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.ProgramService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController // 전체 ResponseBody 해줘
@RequestMapping("/program")
@Api(tags = "program-rest-controller")
@CrossOrigin("*")
public class ProgramRestController {
	
	@Autowired
	private ProgramService programService;

	// 전체 목록 가져와.
	@ApiOperation(value="프로그램 전체 조회", notes = "프로그램 다 가져왕")
	@GetMapping("/list")
	public ResponseEntity<?> list(){		
		List<Program> list = programService.getProgramList();  // 전체 조회 		
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Program>>(list, HttpStatus.OK);
	}
	
	// 프로그램 하나 가져와.
	@ApiOperation(value="프로그램 하나 조회", notes = "프로그램 하나 가져왕")
	@GetMapping("/{program_id}")
	public ResponseEntity<?> detail(@PathVariable int program_id){		
		Program program = programService.getProgram(program_id);  // 하나 조회 		
		if(program == null) return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Program>(program, HttpStatus.OK);
	}
	
	// 등록
	// 로그인 여부에 대한 확인이 없음 => ★뷰에서 로그인했을 때만 등록 버튼을 보이게 구현 필요★
	@ApiOperation(value="프로그램 등록", notes = "프로그램을 등록하자")
	@PostMapping("/write")
	public ResponseEntity<?> write(Program program){
		int result = programService.writeReview(program);
		
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Program>(program, HttpStatus.CREATED);
	}
	
	// 삭제
	// 로그인 여부에 대한 확인이 없음 => ★뷰에서 로그인했을 때만 삭제 버튼을 보이게 구현 필요★
	@ApiOperation(value="프로그램 삭제", notes = "프로그램을 삭제하자")
	@DeleteMapping("/{program_id}/delete")
	public ResponseEntity<?> delete(@PathVariable int program_id, User user){
		int result = programService.removeProgram(program_id);
		
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	// 수정
	// 로그인 여부에 대한 확인이 없음 => ★뷰에서 로그인했을 때만 수정 버튼을 보이게 구현 필요★
	@ApiIgnore
	@ApiOperation(value="프로그램 수정", notes = "프로그램 수정하자")
	@PutMapping("/update")
	public ResponseEntity<?> update(Program program){
		int result = programService.updateProgram(program);
		
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Program>(program, HttpStatus.OK);
	}	
	
}
