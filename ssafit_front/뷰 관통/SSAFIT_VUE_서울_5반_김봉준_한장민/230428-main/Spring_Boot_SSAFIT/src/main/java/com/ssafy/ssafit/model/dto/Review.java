package com.ssafy.ssafit.model.dto;

public class Review {
	
	private int reviewId;
	private int videoId;
	private String userId;
	private String content;
	
	public Review() {
		super();
	}
	public Review(int reviewId, int videoId, String userId, String content) {
		super();
		this.reviewId = reviewId;
		this.videoId = videoId;
		this.userId = userId;
		this.content = content;
	}
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", videoId=" + videoId + ", userId=" + userId + ", content=" + content
				+ "]";
	}
	

	
	
}
