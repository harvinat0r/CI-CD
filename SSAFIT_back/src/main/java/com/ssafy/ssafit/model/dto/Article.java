package com.ssafy.ssafit.model.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;

@ApiModel(value="게시판 바구니", description = "게시판 정보임")
public class Article {
	private int article_id;
	private String user_id;
	private String article_title;
	private String article_content;
	private int article_view_cnt;
	private int article_review_cnt;
	private int article_like_cnt;
	private int article_unlike_cnt;
	private Date article_reg_date;
	private boolean article_property;
	private String article_video_id;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(int article_id, String user_id, String article_title, String article_content, int article_view_cnt,
			int article_review_cnt, int article_like_cnt, int article_unlike_cnt, Date article_reg_date,
			boolean article_property, String article_video_id) {
		super();
		this.article_id = article_id;
		this.user_id = user_id;
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_view_cnt = article_view_cnt;
		this.article_review_cnt = article_review_cnt;
		this.article_like_cnt = article_like_cnt;
		this.article_unlike_cnt = article_unlike_cnt;
		this.article_reg_date = article_reg_date;
		this.article_property = article_property;
		this.article_video_id = article_video_id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public int getArticle_view_cnt() {
		return article_view_cnt;
	}

	public void setArticle_view_cnt(int article_view_cnt) {
		this.article_view_cnt = article_view_cnt;
	}

	public int getArticle_review_cnt() {
		return article_review_cnt;
	}

	public void setArticle_review_cnt(int article_review_cnt) {
		this.article_review_cnt = article_review_cnt;
	}

	public int getArticle_like_cnt() {
		return article_like_cnt;
	}

	public void setArticle_like_cnt(int article_like_cnt) {
		this.article_like_cnt = article_like_cnt;
	}

	public int getArticle_unlike_cnt() {
		return article_unlike_cnt;
	}

	public void setArticle_unlike_cnt(int article_unlike_cnt) {
		this.article_unlike_cnt = article_unlike_cnt;
	}

	public Date getArticle_reg_date() {
		return article_reg_date;
	}

	public void setArticle_reg_date(Date article_reg_date) {
		this.article_reg_date = article_reg_date;
	}

	public boolean isArticle_property() {
		return article_property;
	}

	public void setArticle_property(boolean article_property) {
		this.article_property = article_property;
	}

	public String getArticle_video_id() {
		return article_video_id;
	}

	public void setArticle_video_id(String article_video_id) {
		this.article_video_id = article_video_id;
	}

	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", user_id=" + user_id + ", article_title=" + article_title
				+ ", article_content=" + article_content + ", article_view_cnt=" + article_view_cnt
				+ ", article_review_cnt=" + article_review_cnt + ", article_like_cnt=" + article_like_cnt
				+ ", article_unlike_cnt=" + article_unlike_cnt + ", article_reg_date=" + article_reg_date
				+ ", article_property=" + article_property + ", article_video_id=" + article_video_id + "]";
	}
	
	
}
