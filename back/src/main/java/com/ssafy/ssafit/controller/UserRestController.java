package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api-user")
public class UserRestController {

	@Autowired
	private UserService userService;

//	// 전체 유저목록 가져와~~
//	@GetMapping("/users")
//	public List<User> userList() {
//		return userService.getUserList();
//	}

	// 회원가입을 해보자 (form data 형식으로 넘어왔다.)
	// 중복유지도 확인해보자
	@Transactional // 확실하지않음
	@PostMapping("/regist")
	@ApiOperation(value = "회원 가입", notes = "id가 중복되지 않으면 회원가입이 된다.")
	public ResponseEntity<?> signup(@RequestBody User user) {
		int result = userService.signup(user);
		// result가 0이 아니면 등록
		// 등록한 유저 정보 반환
		if (result != 0)
			return new ResponseEntity<User>(user, HttpStatus.CREATED);

		// result가 0이면 등록 실패 (테이블에 해당 'id'가 있으면 실패할 것 같다)
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	// 회원탈퇴
	@DeleteMapping("/withdrawal")
	@ApiOperation(value = "회원 탈퇴", notes = "계정 삭제하고싶어요!")
	public ResponseEntity<?> withdrawal(@RequestBody User user) {
		userService.deleteUser(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	// 로그인 (실제 수행)
	@PostMapping("/login")
	@ApiOperation(value = "로그인", notes = "Id 및 PassWord가 일치하면 session에 사용자 정보 저장합니다.")
	public ResponseEntity<?> login(String id, String password) {
		User tmp = userService.login(id, password);
		if (tmp == null) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<User>(tmp, HttpStatus.OK);
	}

	// 비밀번호 체크
	@PostMapping("/checkPassword")
	@ApiOperation(value = "비밀번호 체크", notes = "비밀번호 확인해봅시다")
	public ResponseEntity<?> checkPassword(User user, String input_password) {
		User tmp = userService.checkPassword(user, input_password);
		if (tmp == null) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<User>(tmp, HttpStatus.OK);
	}

	// 회원정보 수정
	@PutMapping("/{user_id}")
	@ApiOperation(value = "회원 정보 수정", notes = "회원 정보 수정!")
	public ResponseEntity<?> modifyUser(@RequestBody User user) {
		userService.modifyUser(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	} // update

	
	// 프로필 조회
	@GetMapping("/{user_id}/my-page")
	@ApiOperation(value = "프로필 조회", notes = "프로필을 조회해보자")
	public ResponseEntity<?> viewProfile(@RequestBody User user) {
		userService.viewProfile(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	} // viewProfile 

	
	// 찜 목록 조회

	// 랭킹 전체 조회
	@GetMapping("/ranking")
	@ApiOperation(value = "랭킹 전체 조회", notes = "랭킹 전체 조회")
	public ResponseEntity<?> totalRanking() {
		List<User> list = userService.totalRanking();
		
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	} // ranking 
	
	
	// 랭킹 일부 조회
	
	
	

	// 아이디 찾기
//	@PostMapping("/findId")
//	@ApiOperation(value = "아이디 찾기", notes = "아이디를 찾아봅시다")
//	public ResponseEntity<?> findId(String user_name, Date birth, String question_1, String question_2) {
//		userService.findId(user_name, birth, question_1, question_2);
//		return new ResponseEntity<User>(HttpStatus.OK);
//	}
	
	// 비밀번호 찾기
//	@PostMapping("/findPassword")
//	@ApiOperation(value = "비밀번호 찾기", notes = "비밀번호를 찾아봅시다")
//	public ResponseEntity<?> findPassword(String user_id, String user_name, Date birth, String question_1,
//			String question_2) {
//		userService.findPassword(user_id, user_name, birth, question_1, question_2);
//		return new ResponseEntity<User>(HttpStatus.OK);
//	}
} // class UserController 
