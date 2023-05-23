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
	
	// 특정 프로그램에 대한 유저의 좋아요 조회
	Like selectLikeByUser(Map<String, Object> map);
	// 특정 프로그램에 대한 유저의 좋아요 표시
	int insertLike(Map<String, Object> map);
	// 특정 프로그램에 대한 유저의 좋아요 변경
	int updateLike(Map<String, Object> map);
	// 특정 프로그램에 대한 유저의 좋아요 취소
	int deleteLike(Like result);

	// 좋아요 추가
	void increaseLike(int program_id);

	// 싫어요 추가
	void increaseUnLike(int program_id);

	// 좋아요 취소
	void reduceLike(int program_id);
	
	// 싫어요 취소
	void reduceUnLike(int program_id);
}
