package com.springbook.view.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.UsersVO;
import com.springbook.biz.users.impl.UsersDAO;


public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("�α��� ó�� ����");
		
		//1. ����� �Է����� ����
		String id = request.getParameter("usersId");
		String pw = request.getParameter("usersPw");
		
		//2. DB����ó��
		UsersVO vo = new UsersVO();
		vo.setUsersId(id);
		vo.setUsersPw(pw);
		
		UsersDAO usersDAO = new UsersDAO();
		UsersVO user = usersDAO.getUsers(vo);
		
		//3. ȭ�� �׺���̼�
		ModelAndView mav = new ModelAndView();
		if(user != null) { // �α��� ����
			mav.setViewName("getBoardList.do");
		}
		else { // �α��� ����
			mav.setViewName("login.jsp");
		}
		return mav;
	}

}
