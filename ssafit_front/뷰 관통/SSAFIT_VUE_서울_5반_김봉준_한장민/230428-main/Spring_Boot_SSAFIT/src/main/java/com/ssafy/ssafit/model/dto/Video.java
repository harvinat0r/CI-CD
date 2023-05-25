package com.ssafy.ssafit.model.dto;

public class Video {
	
	private int videoId; // 주요값
	private String title;
	private String fitPartName;
	private String youtubeId;
	private String channelName;
	private String userId;
	private int viewCnt;
	public Video() {
		super();
	}
	


	public Video(int videoId, String title, String fitPartName, String youtubeId, String channelName, String userId,
			int viewCnt) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.fitPartName = fitPartName;
		this.youtubeId = youtubeId;
		this.channelName = channelName;
		this.userId = userId;
		this.viewCnt = viewCnt;
	}

	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFitPartName() {
		return fitPartName;
	}
	public void setFitPartName(String fitPartName) {
		this.fitPartName = fitPartName;
	}
	public String getYoutubeId() {
		return youtubeId;
	}
	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", fitPartName=" + fitPartName + ", youtubeId="
				+ youtubeId + ", channelName=" + channelName + ", userId=" + userId + ", viewCnt=" + viewCnt + "]";
	}

	
	

}
