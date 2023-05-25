package com.ssafy.ssafit.model.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;

@ApiModel(value="검색 바구니", description = "검색 정보임")
public class Search {
	private int search_id;
	private String exercise_name;
	private Date search_reg_date;
	
	public Search() {
		// TODO Auto-generated constructor stub
	}

	public Search(int search_id, String exercise_name, Date search_reg_date) {
		super();
		this.search_id = search_id;
		this.exercise_name = exercise_name;
		this.search_reg_date = search_reg_date;
	}

	public int getSearch_id() {
		return search_id;
	}

	public void setSearch_id(int search_id) {
		this.search_id = search_id;
	}

	public String getExercise_name() {
		return exercise_name;
	}

	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
	}

	public Date getSearch_reg_date() {
		return search_reg_date;
	}

	public void setSearch_reg_date(Date search_reg_date) {
		this.search_reg_date = search_reg_date;
	}

	@Override
	public String toString() {
		return "Search [search_id=" + search_id + ", exercise_name=" + exercise_name + ", search_reg_date="
				+ search_reg_date + "]";
	}
	
	
}
