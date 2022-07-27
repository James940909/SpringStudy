package com.springbook.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.UsersVO;
import com.springbook.biz.users.impl.UsersDAO;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1. 클라이언트가 요청한 path 정보를 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		//2. 클라이언트의 요청 path에 따라 기능처리
		if(path.equals("/login.do")) {
			System.out.println("로그인처리");
			
			//1.사용자의 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB연동 처리
			UsersVO vo = new UsersVO();
			vo.setUsersId(id);
			vo.setUsersPw(password);
			
			UsersDAO usersDAO = new UsersDAO();
			UsersVO user = usersDAO.getUsers(vo);
			
			//3. 화면 네비게이션
			if(user != null) {
				response.sendRedirect("getBoardList.jsp");
			}
			else {
				response.sendRedirect("login.jsp");
			}
			
		}
		else if(path.equals("/logout.do")) {
			System.out.println("로그아웃처리");
		}
		else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록");
		}
		else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정");
		}
		else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제");
		}
		else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세보기");
		}
		else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록보기");
		}
		else if(path.equals("/signUp.do")) {
			//1.사용자의 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			//2. DB연동 처리
			UsersVO vo = new UsersVO();
			vo.setUsersId(id);
			vo.setUsersPw(password);
			vo.setUsersName(name);
			vo.setUsersEmail(email);
			vo.setUsersPhone(phone);
			vo.setUsersAddress(address);
			
			System.out.println(vo.toString());
			
			UsersDAO usersDAO = new UsersDAO();
			System.out.println("확인0");
			usersDAO.insertUsers(vo);
			
			System.out.println("확인1");
			
			//3. 화면 네비게이션
			response.sendRedirect("login.jsp");
			System.out.println("확인2");
		}
	}

}
