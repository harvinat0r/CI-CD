package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ProgramDao;
import com.ssafy.ssafit.model.dto.Program;

@Service
public class ProgramServieceImpl implements ProgramService {

	private ProgramDao programDao;
	
	@Autowired
	public void setProgramDao(ProgramDao programDao) {
		this.programDao = programDao;
	}
	
	// 프로그램 전체 조회
	@Override
	public List<Program> getProgramList() {
		return programDao.selectAll();
	}
	
	// 프로그램 하나 조회
	@Override
	public Program getProgram(int program_id) {
		return programDao.selectOne(program_id);
	}
	
	// 프로그램 등록
	@Override
	public int writeReview(Program program) {
		return programDao.insertProgram(program);
	}

	// 프로그램 삭제
	@Override
	public int removeProgram(int program_id) {
		return programDao.deleteProgram(program_id);
	}
	
	// 프로그램 수정
	@Override
	public int updateProgram(Program program) {
		return programDao.updateProgram(program);
	}
}
