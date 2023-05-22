package com.ssafy.ssafit.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ProgramDao;
import com.ssafy.ssafit.model.dto.Like;
import com.ssafy.ssafit.model.dto.Program;
import com.ssafy.ssafit.model.dto.User;

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

	// 프로그램에 대한 좋아요 처리
	@Override
	public int likeProgram(User user, int program_id, int like_property) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user.getUser_id());
		map.put("program_id", program_id);
		map.put("like_property", like_property);
		Like result = programDao.selectLikeByUser(map);
			
		if(result == null) return programDao.insertLike(map);
		else if(like_property != result.getLike_property()) return programDao.updateLike(map);
		return programDao.deleteLike(result);
	}
}
