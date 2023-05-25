package com.ssafy.ssafit.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="운동 루틴 바구니", description = "루틴 정보임")
public class Routine {
	private int routine_id;
	private String user_id;
	private String exercise_name;
	private int repetition;
	private int set;
	private String routine_reg_date;
	
	public Routine() {
		// TODO Auto-generated constructor stub
	}

	public Routine(int routine_id, String user_id, String exercise_name, int repetition, int set,
			String routine_reg_date) {
		super();
		this.routine_id = routine_id;
		this.user_id = user_id;
		this.exercise_name = exercise_name;
		this.repetition = repetition;
		this.set = set;
		this.routine_reg_date = routine_reg_date;
	}

	public int getRoutine_id() {
		return routine_id;
	}

	public void setRoutine_id(int routine_id) {
		this.routine_id = routine_id;
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

	public int getRepetition() {
		return repetition;
	}

	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	public String getRoutine_reg_date() {
		return routine_reg_date;
	}

	public void setRoutine_reg_date(String routine_reg_date) {
		this.routine_reg_date = routine_reg_date;
	}

	@Override
	public String toString() {
		return "Routine [routine_id=" + routine_id + ", user_id=" + user_id + ", exercise_name=" + exercise_name
				+ ", repetition=" + repetition + ", set=" + set + ", routine_reg_date=" + routine_reg_date + "]";
	}
	
	
}
