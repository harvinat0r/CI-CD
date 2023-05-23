package com.ssafy.ssafit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/user")
@Api(tags = "user-rest-controller")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private UserService userService;

	// 전체 유저목록 가져와~~
	@GetMapping("/users")
	public List<User> userList() {
		return userService.getUserList();
	}

	// 회원가입을 해보자 (form data 형식으로 넘어왔다.)
	@PostMapping("/signup")
	@ApiOperation(value="사용자 회원가입", notes="id가 중복되지 않으면 회원가입이 된다.")
	public ResponseEntity<?> signup(User user) {
		int result = userService.signup(user);
		//result가 0이 아니면 등록
		// 등록한 유저 정보 반환
		if(result != 0) return new ResponseEntity<User>(user, HttpStatus.CREATED);
		
		// result가 0이면 등록 실패 (테이블에 해당 'id'가 있으면 실패할 것 같다)
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	// 로그인 (실제 수행)
	@PostMapping("/login")
	@ApiOperation(value="사용자 로그인", notes="Id 및 PassWord가 일치하면 session에 사용자 정보 저장합니다.")
	public ResponseEntity<?> login(String id, String password) {
		User tmp = userService.login(id, password);
		if(tmp == null) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<User>(tmp, HttpStatus.OK);
	}

}
