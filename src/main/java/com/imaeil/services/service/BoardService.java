package com.imaeil.services.service;

import java.util.List;

import com.imaeil.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> selectBoards();
	public BoardVO selectBoard();
	
	public void insertBoard(BoardVO boardVO);
	
	public void updateBoard(BoardVO boardVO);
	
	public void deleteBoard(BoardVO boardVO);
}
