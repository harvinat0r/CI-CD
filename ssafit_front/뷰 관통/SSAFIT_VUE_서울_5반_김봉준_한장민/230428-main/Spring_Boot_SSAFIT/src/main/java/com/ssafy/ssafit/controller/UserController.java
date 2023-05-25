package com.ssafy.ssafit.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;
import com.ssafy.ssafit.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "유저 컨트롤러")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/user")
	@ApiOperation(value = "id, password가 일치하는 경우 사용자를 로그인합니다", response = User.class)
	public ResponseEntity<Map<String, Object>> doLogin(User user){
			
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println(user);
		
		HttpStatus status = null;
		
		try {
			
			if(user != null) {
				User loginUser = userService.searchById(user.getUserId());
				
				if (loginUser.getPassword().equals(user.getPassword())){
					user.setName(loginUser.getName());
					
					result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
					result.put("user", user);
					result.put("message", "성공~");
					status = HttpStatus.ACCEPTED;
					
				} else {
					result.put("message", "까비~");
					status = HttpStatus.NO_CONTENT;
				}
			} else {
				result.put("message", "까비~");
				status = HttpStatus.NO_CONTENT;
			}
			
		} catch(UnsupportedEncodingException e) {
			result.put("message", "까비~");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(result, status);
		
	}
	
	@PostMapping("/user")
	@ApiOperation(value = "사용자 정보를 등록합니다.", response = Integer.class)
	public ResponseEntity<?> insertUser(User user){
		
		int result = userService.insertUser(user);
		
		if(result > 0) return new ResponseEntity<User>(user, HttpStatus.CREATED);
		else return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		
	}
	
}
