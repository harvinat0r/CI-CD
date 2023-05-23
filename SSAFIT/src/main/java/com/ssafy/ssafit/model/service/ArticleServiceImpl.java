package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ArticleDao;
import com.ssafy.ssafit.model.dto.Article;
import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.User;

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

	// 게시판 종아요
	@Override
	public int likeArticle(User user, int article_id, int like_property) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user.getUser_id());
		map.put("article_id", article_id);
		map.put("like_property", like_property);
		Like result = articleDao.selectLikeByUser(map);
			
		if(result == null) {
			if(like_property == 1) articleDao.increaseLike(article_id);
			else articleDao.increaseUnLike(article_id);
			return articleDao.insertLike(map);
		}
		else if(like_property != result.getLike_property()) {
			if(like_property == 1) {
				articleDao.increaseLike(article_id);
				articleDao.reduceUnLike(article_id);
			}
			else {
				articleDao.reduceLike(article_id);
				articleDao.increaseUnLike(article_id);
			}
			return articleDao.updateLike(map);
		}
		if(like_property == 1) articleDao.reduceLike(article_id);
		else articleDao.reduceUnLike(article_id);
		return articleDao.deleteLike(result);
	}

}
