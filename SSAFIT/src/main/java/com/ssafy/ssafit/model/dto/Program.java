package com.ssafy.ssafit.model.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;

@ApiModel(value="운동 프로그램 바구니", description = "프로그램 정보임")
public class Program {
	private int program_id;
	private String user_id;
	private String program_difficulty;
	private String program_title;
	private String program_content;
	private int program_view_cnt;
	private int program_review_cnt;
	private int program_like_cnt;
	private int program_unlike_cnt;
	private Date program_reg_date;
	private int program_goal;
	private String program_video_id;
	
	public Program() {
		// TODO Auto-generated constructor stub
	}

	

	public Program(String user_id, String program_difficulty, String program_title, String program_content,
			int program_goal, String program_video_id) {
		super();
		this.user_id = user_id;
		this.program_difficulty = program_difficulty;
		this.program_title = program_title;
		this.program_content = program_content;
		this.program_goal = program_goal;
		this.program_video_id = program_video_id;
	}



	public Program(String user_id, String program_difficulty, String program_title, String program_content,
			int program_goal) {
		super();
		this.user_id = user_id;
		this.program_difficulty = program_difficulty;
		this.program_title = program_title;
		this.program_content = program_content;
		this.program_goal = program_goal;
	}



	public Program(int program_id, String user_id, String program_difficulty, String program_title,
			String program_content, int program_view_cnt, int program_review_cnt, int program_like_cnt,
			int program_unlike_cnt, Date program_reg_date, int program_goal, String program_video_id) {
		super();
		this.program_id = program_id;
		this.user_id = user_id;
		this.program_difficulty = program_difficulty;
		this.program_title = program_title;
		this.program_content = program_content;
		this.program_view_cnt = program_view_cnt;
		this.program_review_cnt = program_review_cnt;
		this.program_like_cnt = program_like_cnt;
		this.program_unlike_cnt = program_unlike_cnt;
		this.program_reg_date = program_reg_date;
		this.program_goal = program_goal;
		this.program_video_id = program_video_id;
	}



	public int getProgram_id() {
		return program_id;
	}

	public void setProgram_id(int program_id) {
		this.program_id = program_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getProgram_difficulty() {
		return program_difficulty;
	}

	public void setProgram_difficulty(String program_difficulty) {
		this.program_difficulty = program_difficulty;
	}

	public String getProgram_title() {
		return program_title;
	}

	public void setProgram_title(String program_title) {
		this.program_title = program_title;
	}

	public String getProgram_content() {
		return program_content;
	}

	public void setProgram_content(String program_content) {
		this.program_content = program_content;
	}

	public int getProgram_view_cnt() {
		return program_view_cnt;
	}

	public void setProgram_view_cnt(int program_view_cnt) {
		this.program_view_cnt = program_view_cnt;
	}

	public int getProgram_review_cnt() {
		return program_review_cnt;
	}

	public void setProgram_review_cnt(int program_review_cnt) {
		this.program_review_cnt = program_review_cnt;
	}

	public int getProgram_like_cnt() {
		return program_like_cnt;
	}

	public void setProgram_like_cnt(int program_like_cnt) {
		this.program_like_cnt = program_like_cnt;
	}

	public Date getProgram_reg_date() {
		return program_reg_date;
	}

	public void setProgram_reg_date(Date program_reg_date) {
		this.program_reg_date = program_reg_date;
	}

	public int isProgram_goal() {
		return program_goal;
	}

	public void setProgram_goal(int program_goal) {
		this.program_goal = program_goal;
	}

	public String getProgram_video_id() {
		return program_video_id;
	}

	public void setProgram_video_id(String program_video_id) {
		this.program_video_id = program_video_id;
	}

	public int getProgram_unlike_cnt() {
		return program_unlike_cnt;
	}

	public void setProgram_unlike_cnt(int program_unlike_cnt) {
		this.program_unlike_cnt = program_unlike_cnt;
	}



	@Override
	public String toString() {
		return "Program [program_id=" + program_id + ", user_id=" + user_id + ", program_difficulty="
				+ program_difficulty + ", program_title=" + program_title + ", program_content=" + program_content
				+ ", program_view_cnt=" + program_view_cnt + ", program_review_cnt=" + program_review_cnt
				+ ", program_like_cnt=" + program_like_cnt + ", program_unlike_cnt=" + program_unlike_cnt
				+ ", program_reg_date=" + program_reg_date + ", program_goal=" + program_goal + ", program_video_id="
				+ program_video_id + "]";
	}
	
	
}
