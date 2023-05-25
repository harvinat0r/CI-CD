package com.ssafy.ssafit.model.dto;

import io.swagger.annotations.ApiModel;


@ApiModel(value="사용자 정보 바구니", description = "사용자 정보임")
public class User {
	private String user_id;
	private String user_password;
	private String user_name;
	private String user_nickname;
	private String email;
	private String birth;
	private int phone_no;
	private boolean gender;
	private int squat;
	private int bench_press;
	private int dead_lift;
	private int sbd;
	private String question_1;
	private String question_2;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String user_id, String user_password, String user_name, String user_nickname, String email,
			String birth, int phone_no, boolean gender, int squat, int bench_press, int dead_lift, int sbd,
			String question_1, String question_2) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_nickname = user_nickname;
		this.email = email;
		this.birth = birth;
		this.phone_no = phone_no;
		this.gender = gender;
		this.squat = squat;
		this.bench_press = bench_press;
		this.dead_lift = dead_lift;
		this.sbd = sbd;
		this.question_1 = question_1;
		this.question_2 = question_2;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getSquat() {
		return squat;
	}

	public void setSquat(int squat) {
		this.squat = squat;
	}

	public int getBench_press() {
		return bench_press;
	}

	public void setBench_press(int bench_press) {
		this.bench_press = bench_press;
	}

	public int getDead_lift() {
		return dead_lift;
	}

	public void setDead_lift(int dead_lift) {
		this.dead_lift = dead_lift;
	}

	public int getSbd() {
		return sbd;
	}

	public void setSbd(int sbd) {
		this.sbd = sbd;
	}

	public String getQuestion_1() {
		return question_1;
	}

	public void setQuestion_1(String question_1) {
		this.question_1 = question_1;
	}

	public String getQuestion_2() {
		return question_2;
	}

	public void setQuestion_2(String question_2) {
		this.question_2 = question_2;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_nickname=" + user_nickname + ", email=" + email + ", birth=" + birth + ", phone_no="
				+ phone_no + ", gender=" + gender + ", squat=" + squat + ", bench_press=" + bench_press + ", dead_lift="
				+ dead_lift + ", sbd=" + sbd + ", question_1=" + question_1 + ", question_2=" + question_2 + "]";
	}
	
	
}
