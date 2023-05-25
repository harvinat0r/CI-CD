package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.SearchCondition;
import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {

	//전체 비디오 몽땅 들고 오쎄용
		public List<Video> selectAll(SearchCondition searchCondition);
		
		//ID에 해당하는 비디오 하나 가져오기
		public Video selectOne(int id);
		
		//비디오 등록
		public int insertVideo(Video video);
		
		//비디오 삭제 
		public int deleteVideo(int id);
		
		//비디오 수정
		public int updateVideo(Video video);
		
		//비디오 조회수 증가
//		public void updateViewCnt(int id);
	
}
