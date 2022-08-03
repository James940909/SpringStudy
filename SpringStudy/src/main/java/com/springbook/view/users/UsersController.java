package com.springbook.view.users;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.UsersVO;
import com.springbook.biz.users.impl.UsersDAO;

@Controller
public class UsersController {
	
	// �α���
	@RequestMapping(value="/login.do")
	public String login(UsersVO vo, UsersDAO usersDAO) {
		
		if(usersDAO.getUsers(vo) != null) {
			return "getBoardList.do";
		}
		
		else {
			return "login.jsp";
		}
		
	}
	
	// �α׾ƿ�
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "login.jsp";
	}
	
}
