package com.springbook.view.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	// 글등록
	@RequestMapping(value="/insertBoard.do") // HandlerMapping을 대체하는 어노테이션
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리 시작");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
		
	}
	
	// 글수정
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
		
	}
	
	// 글 삭제
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
		
	}
	
	// 글 상세보기
	@RequestMapping(value="/getBoard.do")
	public  ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}
	
	// 글 목록보기
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리시작");
		
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model 정보 저장
		mav.setViewName("getBoardList.jsp"); // View 정보 저장	
		return mav;
	}
}
