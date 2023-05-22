package com.ssafy.ssafit.model.dto;


import java.util.Date;

import io.swagger.annotations.ApiModel;

@ApiModel(value="리뷰 바구니", description = "리뷰 정보임")
public class Review {
    private int review_id;
    private String user_id;
    private int program_id;
    private int parent_id;
    private int article_id;
    private String review_content;
    private int review_like_cnt;
    private int depth;
    private Date review_reg_date;
    
    public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int review_id, String user_id, int program_id, int parent_id, int article_id, String review_content,
			int review_like_cnt, int depth, Date review_reg_date) {
		super();
		this.review_id = review_id;
		this.user_id = user_id;
		this.program_id = program_id;
		this.parent_id = parent_id;
		this.article_id = article_id;
		this.review_content = review_content;
		this.review_like_cnt = review_like_cnt;
		this.depth = depth;
		this.review_reg_date = review_reg_date;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getProgram_id() {
		return program_id;
	}

	public void setProgram_id(int program_id) {
		this.program_id = program_id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getReview_like_cnt() {
		return review_like_cnt;
	}

	public void setReview_like_cnt(int review_like_cnt) {
		this.review_like_cnt = review_like_cnt;
	}

	public int isDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Date getReview_reg_date() {
		return review_reg_date;
	}

	public void setReview_reg_date(Date review_reg_date) {
		this.review_reg_date = review_reg_date;
	}

	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", user_id=" + user_id + ", program_id=" + program_id + ", parent_id="
				+ parent_id + ", article_id=" + article_id + ", review_content=" + review_content + ", review_view_cnt="
				+ ", review_like_cnt=" + review_like_cnt + ", depth=" + depth + ", review_reg_date="
				+ review_reg_date + "]";
	}
    
    
}

