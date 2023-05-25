package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Article;

public interface ArticleService {

	// 속성에 맞는 게시판 가져오기
	// 0 : 루틴연구소, 1: 자유게시판, 2: 헬스친구찾기
	List<Article> getArticleByProperty(int article_property);

	// 게시판 하나 가져오기
	Article getArticle(int article_id);

	// 게시판 등록
	int writeArticle(Article article);

	// 게시판 삭제
	int removeArticle(int article_id);

	// 게시판 수정
	int updateArticle(Article article);

}
