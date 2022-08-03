package com.springbook.view.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	// �۵��
	@RequestMapping(value="/insertBoard.do") // HandlerMapping�� ��ü�ϴ� ������̼�
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ��� ó�� ����");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
		
	}
	
	// �ۼ���
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
		
	}
	
	// �� ����
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
		
	}
	
	// �� �󼼺���
	@RequestMapping(value="/getBoard.do")
	public  ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}
	
	// �� ��Ϻ���
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� ��� �˻� ó������");
		
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model ���� ����
		mav.setViewName("getBoardList.jsp"); // View ���� ����	
		return mav;
	}
}