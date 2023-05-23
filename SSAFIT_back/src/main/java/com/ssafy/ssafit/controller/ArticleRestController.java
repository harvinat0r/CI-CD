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

import com.ssafy.ssafit.model.dto.Article;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.ArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController // 전체 ResponseBody 해줘
@RequestMapping("/article")
@Api(tags = "article-rest-controller")
@CrossOrigin("*")
public class ArticleRestController {
	
	@Autowired
	private ArticleService articleService;

	// 게시판 가져와. 등록 날짜 기준 내림차순 정렬
	@ApiOperation(value="속성에 맞는 게시판 전체 조회", notes = "속성에 맞는 게시판 다 가져왕")
	@GetMapping("/{article_property}/list")
	public ResponseEntity<?> list(@PathVariable int article_property){		
		List<Article> list = articleService.getArticleByProperty(article_property); 		
		if(list == null || list.size() == 0) return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}
	
	// 게시판 하나 가져와.
	@ApiOperation(value="게시판 하나 조회", notes = "게시판 하나 가져왕")
	@GetMapping("/{article_id}/detail")
	public ResponseEntity<?> detail(@PathVariable int article_id){	
		Article article = articleService.getArticle(article_id);  // 하나 조회 		
		if(article == null) return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
	// 등록
	// 로그인 여부에 대한 확인이 없음 => ★뷰에서 로그인했을 때만 등록 버튼을 보이게 구현 필요★
	@ApiOperation(value="게시판 등록", notes = "게시판을 등록하자")
	@PostMapping("/write")
	public ResponseEntity<?> write(@RequestBody Article article){
		int result = articleService.writeArticle(article);
		
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Article>(article, HttpStatus.CREATED);
	}
	
	// 삭제
	// 로그인 여부에 대한 확인이 없음 => ★뷰에서 로그인했을 때만 삭제 버튼을 보이게 구현 필요★
	@ApiOperation(value="게시판 삭제", notes = "게시판을 삭제하자")
	@DeleteMapping("/{article_id}/delete")
	public ResponseEntity<?> delete(@PathVariable int article_id){
		int result = articleService.removeArticle(article_id);
		
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	// 수정
	// 로그인 여부에 대한 확인이 없음 => ★뷰에서 로그인했을 때만 수정 버튼을 보이게 구현 필요★
	@ApiOperation(value="게시판 수정", notes = "게시판 수정하자")
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Article article){
		int result = articleService.updateArticle(article);
		
		if(result == 0) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
	
}
