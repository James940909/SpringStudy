package com.springbook.biz;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		//1. Spring �����̳� ����
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring �����̳ʷκ��� BoardServiceImpl ��ü�� Lookup�Ѵ�.
		BoardService boardService = (BoardService) container.getBean("boardService");
		UsersService usersService = (UsersService) container.getBean("usersService");
		
		/*//3. �� ��� ��� �׽�Ʈ!
		BoardVO vo = new BoardVO();
		vo.setTitle("�ӽ�����7");
		vo.setWriter("ȫ�浿7");
		vo.setContent("�ӽó����Դϴ�77!");
		boardService.insertBoard(vo);
		
		//4. �� ��� �˻� ��� �׽�Ʈ!
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println(board.toString());
		}*/
		
		//3. ȸ�� ��� ��� �׽�Ʈ!
		UsersVO vo = new UsersVO();
		vo.setUsersId("aaa");
		vo.setUsersPw("111");
		vo.setUsersName("�׽�Ʈ");
		vo.setUsersEmail("�׽�Ʈ");
		vo.setUsersPhone("�׽�Ʈ");
		vo.setUsersAddress("�׽�Ʈ");
		usersService.insertUsers(vo);
		
		//4. ȸ�� ��� �˻� ��� �׽�Ʈ!
		List<UsersVO> usersList = usersService.getUsersList(vo);
		for(UsersVO users : usersList) {
			System.out.println(users.toString());
		}
		
		//5. Spring �����̳� ����
		container.close();
	}

}
