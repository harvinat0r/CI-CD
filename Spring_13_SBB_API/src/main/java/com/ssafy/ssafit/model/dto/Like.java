package com.ssafy.ssafit.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="좋아요 바구니", description = "좋아요 정보임")
public class Like {
	private int like_id;
	private String user_id;
	private String exercise_name;
	private int program_id;
	private int review_id;
	private int article_id;
	private int like_property;
	
	public Like() {
		// TODO Auto-generated constructor stub
	}

	public Like(int like_id, String user_id, String exercise_name, int program_id, int review_id, int article_id,
			int like_property) {
		super();
		this.like_id = like_id;
		this.user_id = user_id;
		this.exercise_name = exercise_name;
		this.program_id = program_id;
		this.review_id = review_id;
		this.article_id = article_id;
		this.like_property = like_property;
	}

	public int getLike_id() {
		return like_id;
	}

	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getExercise_name() {
		return exercise_name;
	}

	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
	}

	public int getProgram_id() {
		return program_id;
	}

	public void setProgram_id(int program_id) {
		this.program_id = program_id;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public int getLike_property() {
		return like_property;
	}

	public void setLike_property(int like_property) {
		this.like_property = like_property;
	}

	@Override
	public String toString() {
		return "like [like_id=" + like_id + ", user_id=" + user_id + ", exercise_name=" + exercise_name
				+ ", program_id=" + program_id + ", review_id=" + review_id + ", article_id=" + article_id
				+ ", like_property=" + like_property + "]";
	}
	
	
}
