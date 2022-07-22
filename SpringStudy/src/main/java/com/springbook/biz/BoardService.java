package com.springbook.biz;

import java.util.List;

public interface BoardService {
	//�۵��
	void insertBoard(BoardVO vo);
	//�ۼ���
	void updateBoard(BoardVO vo);
	//�ۻ���
	void deleteBoard(BoardVO vo);
	//�� �󼼺���
	BoardVO getBoard(BoardVO vo);
	//�� �����ȸ
	List<BoardVO> getBoardList(BoardVO vo);
}
