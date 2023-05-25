package com.ssafy.ssafit.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private static final String SALT = "SSAFIT";
	
	// 토큰 생성
	// 인자로 키와 밸류가 넘어왔다라고만 처리
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		
		// 테스트할거라 유효기간을 지우자
		return Jwts.builder()
				   .setHeaderParam("alg", "HS256")
				   .setHeaderParam("typ", "JWT") // 헤더끝
				   .claim(claimId, data)
//				   .setExpiration(new Date(System.currentTimeMillis()+3000)) // 유효기간, 페이로드 완료
				   .signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))
				   .compact();
		
	}
	
	// 유효성 검사
	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
	}
	
}
