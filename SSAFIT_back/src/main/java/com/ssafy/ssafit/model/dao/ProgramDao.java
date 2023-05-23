package com.ssafy.ssafit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.Program;

public interface ProgramDao {

	// 프로그램 전체 조회
	List<Program> selectAll();

	// 프로그램 하나 조회
	Program selectOne(int program_id);
	
	// 프로그램 등록
	int insertProgram(Program program);

	// 프로그램 삭제
	int deleteProgram(int program_id);
	
	// 프로그램 수정
	int updateProgram(Program program);

	// 조회수 증가
	void increaseView(int program_id);
}
