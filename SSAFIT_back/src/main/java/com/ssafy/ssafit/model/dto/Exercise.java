package com.ssafy.ssafit.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "운동 바구니", description = "운동 정보임")
public class Exercise {
	private String exercise_name;
	private String exercise_part;
	private int exercise_search_cnt;
	private int exercise_like_cnt;
	private String exercise_desc;
	private String video_id;
	
	public Exercise() {
		// TODO Auto-generated constructor stub
	}

	public Exercise(String exercise_name, String exercise_part, int exercise_search_cnt, int exercise_like_cnt,
			String exercise_desc, String video_id) {
		super();
		this.exercise_name = exercise_name;
		this.exercise_part = exercise_part;
		this.exercise_search_cnt = exercise_search_cnt;
		this.exercise_like_cnt = exercise_like_cnt;
		this.exercise_desc = exercise_desc;
		this.video_id = video_id;
	}

	public String getExercise_name() {
		return exercise_name;
	}

	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
	}

	public String getExercise_part() {
		return exercise_part;
	}

	public void setExercise_part(String exercise_part) {
		this.exercise_part = exercise_part;
	}

	public int getExercise_search_cnt() {
		return exercise_search_cnt;
	}

	public void setExercise_search_cnt(int exercise_search_cnt) {
		this.exercise_search_cnt = exercise_search_cnt;
	}

	public int getExercise_like_cnt() {
		return exercise_like_cnt;
	}

	public void setExercise_like_cnt(int exercise_like_cnt) {
		this.exercise_like_cnt = exercise_like_cnt;
	}

	public String getExercise_desc() {
		return exercise_desc;
	}

	public void setExercise_desc(String exercise_desc) {
		this.exercise_desc = exercise_desc;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	@Override
	public String toString() {
		return "Exercise [exercise_name=" + exercise_name + ", exercise_part=" + exercise_part
				+ ", exercise_search_cnt=" + exercise_search_cnt + ", exercise_like_cnt=" + exercise_like_cnt
				+ ", exercise_desc=" + exercise_desc + ", video_id=" + video_id + "]";
	}
	
	
}