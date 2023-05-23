package com.ssafy.ssafit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.Article;
import com.ssafy.ssafit.model.dto.Like;

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

	// 사용자가 해당 영상을 좋아요 혹은 싫어요 했는지 조회
	Like selectLikeByUser(Map<String, Object> map);

	// 좋아요 혹은 싫어요 입력
	int insertLike(Map<String, Object> map);

	// 좋아요 혹은 싫어요 변경
	int updateLike(Map<String, Object> map);

	// 좋아요 혹은 싫어요 취소
	int deleteLike(Like result);

	// 좋아요 증가
	void increaseLike(int article_id);

	// 싫어요 증가
	void increaseUnLike(int article_id);

	// 좋아요 감소
	void reduceLike(int article_id);
	
	// 싫어요 감소
	void reduceUnLike(int article_id);

}
