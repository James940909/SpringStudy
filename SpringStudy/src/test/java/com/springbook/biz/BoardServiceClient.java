package com.springbook.biz;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		//1. Spring 컨테이너 구동
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로부터 BoardServiceImpl 객체를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		UsersService usersService = (UsersService) container.getBean("usersService");
		
		/*//3. 글 등록 기능 테스트!
		BoardVO vo = new BoardVO();
		vo.setTitle("임시제목7");
		vo.setWriter("홍길동7");
		vo.setContent("임시내용입니다77!");
		boardService.insertBoard(vo);
		
		//4. 글 목록 검색 기능 테스트!
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println(board.toString());
		}*/
		
		//3. 회원 등록 기능 테스트!
		UsersVO vo = new UsersVO();
		vo.setUsersId("aaa");
		vo.setUsersPw("111");
		vo.setUsersName("테스트");
		vo.setUsersEmail("테스트");
		vo.setUsersPhone("테스트");
		vo.setUsersAddress("테스트");
		usersService.insertUsers(vo);
		
		//4. 회원 목록 검색 기능 테스트!
		List<UsersVO> usersList = usersService.getUsersList(vo);
		for(UsersVO users : usersList) {
			System.out.println(users.toString());
		}
		
		//5. Spring 컨테이너 종료
		container.close();
	}

}
