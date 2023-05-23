package com.ssafy.ssafit.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="찜 바구니", description = "찜 정보임")
public class Save {
	private String video_id;
	private String user_id;
	
	public Save() {
		// TODO Auto-generated constructor stub
	}

	public Save(String video_id, String user_id) {
		super();
		this.video_id = video_id;
		this.user_id = user_id;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Save [video_id=" + video_id + ", user_id=" + user_id + "]";
	}
	
	
}
