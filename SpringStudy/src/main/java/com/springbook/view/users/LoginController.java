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
		
		System.out.println("로그인 처리 시작");
		
		//1. 사용자 입력정보 추출
		String id = request.getParameter("usersId");
		String pw = request.getParameter("usersPw");
		
		//2. DB연동처리
		UsersVO vo = new UsersVO();
		vo.setUsersId(id);
		vo.setUsersPw(pw);
		
		UsersDAO usersDAO = new UsersDAO();
		UsersVO user = usersDAO.getUsers(vo);
		
		//3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		if(user != null) { // 로그인 성공
			mav.setViewName("getBoardList.do");
		}
		else { // 로그인 실패
			mav.setViewName("login.jsp");
		}
		return mav;
	}

}
