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
		//1. Ŭ���̾�Ʈ�� ��û�� path ������ ����
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		//2. Ŭ���̾�Ʈ�� ��û path�� ���� ���ó��
		if(path.equals("/login.do")) {
			System.out.println("�α���ó��");
			
			//1.������� �Է� ���� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB���� ó��
			UsersVO vo = new UsersVO();
			vo.setUsersId(id);
			vo.setUsersPw(password);
			
			UsersDAO usersDAO = new UsersDAO();
			UsersVO user = usersDAO.getUsers(vo);
			
			//3. ȭ�� �׺���̼�
			if(user != null) {
				response.sendRedirect("getBoardList.jsp");
			}
			else {
				response.sendRedirect("login.jsp");
			}
			
		}
		else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ�ó��");
		}
		else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ���");
		}
		else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ����");
		}
		else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ����");
		}
		else if(path.equals("/getBoard.do")) {
			System.out.println("�� �󼼺���");
		}
		else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��Ϻ���");
		}
		else if(path.equals("/signUp.do")) {
			//1.������� �Է� ���� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			//2. DB���� ó��
			UsersVO vo = new UsersVO();
			vo.setUsersId(id);
			vo.setUsersPw(password);
			vo.setUsersName(name);
			vo.setUsersEmail(email);
			vo.setUsersPhone(phone);
			vo.setUsersAddress(address);
			
			System.out.println(vo.toString());
			
			UsersDAO usersDAO = new UsersDAO();
			System.out.println("Ȯ��0");
			usersDAO.insertUsers(vo);
			
			System.out.println("Ȯ��1");
			
			//3. ȭ�� �׺���̼�
			response.sendRedirect("login.jsp");
			System.out.println("Ȯ��2");
		}
	}

}
