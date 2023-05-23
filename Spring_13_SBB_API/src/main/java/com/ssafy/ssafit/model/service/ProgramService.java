package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Program;
import com.ssafy.ssafit.model.dto.User;

public interface ProgramService {

	// 프로그램 전체 조회
	public List<Program> getProgramList();

	// 프로그램 하나 조회
	public Program getProgram(int program_id);
	
	// 프로그램 등록
	public int writeReview(Program program);
	
	// 프로그램 삭제
	public int removeProgram(int program_id);
	
	// 프로그램 수정
	public int updateProgram(Program program);
}
