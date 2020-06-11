package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	//게시물 리스트
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}
	//게시물 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
		
	}
	//게시물 조회
	@Override
	public BoardVO view(int bno) throws Exception {
		
		return dao.view(bno);
	}

}
