package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ArticleDao;
import com.ssafy.ssafit.model.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;
	
	@Autowired
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	// 속성에 맞는 게시판 가져오기
	// 0 : 루틴연구소, 1: 자유게시판, 2: 헬스친구찾기
	@Override
	public List<Article> getArticleByProperty(int article_property) {
		return articleDao.selectByProperty(article_property);
	}

	// 게시판 하나 가져오기
	@Override
	public Article getArticle(int article_id) {
		articleDao.increaseView(article_id);
		return articleDao.selectOneById(article_id);
	}

	// 게시판 등록
	@Override
	public int writeArticle(Article article) {
		if(article.getArticle_video_id() == null) return articleDao.insertArticle(article);
		return articleDao.insertVideoArticle(article);
	}

	// 게시판 삭제
	@Override
	public int removeArticle(int article_id) {
		return articleDao.deleteArticle(article_id);
	}

	// 게시판 수정
	@Override
	public int updateArticle(Article article) {
		return articleDao.updateArticle(article);
	}

}
