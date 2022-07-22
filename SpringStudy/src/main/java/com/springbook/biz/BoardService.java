package com.springbook.biz;

import java.util.List;

public interface BoardService {
	//글등록
	void insertBoard(BoardVO vo);
	//글수정
	void updateBoard(BoardVO vo);
	//글삭제
	void deleteBoard(BoardVO vo);
	//글 상세보기
	BoardVO getBoard(BoardVO vo);
	//글 목록조회
	List<BoardVO> getBoardList(BoardVO vo);
}
