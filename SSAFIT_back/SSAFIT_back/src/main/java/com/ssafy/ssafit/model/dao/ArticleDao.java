package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Article;

public interface ArticleDao {

	// 속성에 맞는 게시판 가져오기
	// 0 : 루틴연구소, 1: 자유게시판, 2: 헬스친구찾기
	List<Article> selectByProperty(int article_property);

	// 게시판 하나 가져오기
	Article selectOneById(int article_id);

	// 게시판 등록
	int insertArticle(Article article);

	// 영상첨부 게시판 등록
	int insertVideoArticle(Article article);

	// 게시판 삭제
	int deleteArticle(int article_id);

	// 게시판 수정
	int updateArticle(Article article);

	// 조회수 증가
	void increaseView(int article_id);
}
