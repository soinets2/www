package com.imaeil.mapper;

import java.util.List;

import com.imaeil.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> selectBoards();
	public BoardVO selectBoard(long seq);
	
	public void insertBoard(BoardVO boardVO);
	
	public void updateBoard(BoardVO boardVO);
	
	public int deleteBoard(BoardVO boardVO);
}
