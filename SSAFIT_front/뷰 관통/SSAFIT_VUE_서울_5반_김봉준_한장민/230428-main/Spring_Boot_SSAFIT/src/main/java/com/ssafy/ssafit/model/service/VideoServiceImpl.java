package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.VideoDao;
import com.ssafy.ssafit.model.dto.SearchCondition;
import com.ssafy.ssafit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoDao videoDao;

	@Override
	public List<Video> selectAll(SearchCondition searchCondition) {
		return videoDao.selectAll(searchCondition);
	}

	@Override
	public Video selectOne(int id) {
		videoDao.updateViewCnt(id);
		return videoDao.selectOne(id);
	}

	@Override
	public int insertVideo(Video video) {
		return videoDao.insertVideo(video);
	}

	@Override
	public int deleteVideo(int id) {
		return videoDao.deleteVideo(id);
	}

	@Override
	public int updateVideo(Video video) {
		return videoDao.updateVideo(video);
	}

//	@Override
//	public void updateViewCnt(int id) {
//		
//	}

}
