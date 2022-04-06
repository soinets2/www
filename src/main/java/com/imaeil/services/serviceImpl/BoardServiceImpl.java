package com.imaeil.services.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imaeil.domain.BoardVO;
import com.imaeil.mapper.BoardMapper;
import com.imaeil.services.service.BoardService;

import lombok.AllArgsConstructor;

@Service("boardServiceImpl")
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Resource(name = "boardMapper")
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> selectBoards() {
		return boardMapper.selectBoards();
	}
	
	@Override
	public BoardVO selectBoard() {
		
		return null;
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) {
		
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) {
		
	}
	
	@Override
	public void deleteBoard(BoardVO boardVO) {
		
	}
	
}
