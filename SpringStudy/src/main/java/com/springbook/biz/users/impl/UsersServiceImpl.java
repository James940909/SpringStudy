package com.springbook.biz.users.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.UsersService;
import com.springbook.biz.UsersVO;

@Service("usersService")
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UsersDAO usersDAO;

	@Override
	public void insertUsers(UsersVO vo) {
		usersDAO.insertUsers(vo);
	}

	@Override
	public void updateUsers(UsersVO vo) {
		usersDAO.updateUsers(vo);
	}

	@Override
	public void deleteUsers(UsersVO vo) {
		usersDAO.deleteUsers(vo);
	}

	@Override
	public UsersVO getUsers(UsersVO vo) {
		return usersDAO.getUsers(vo);
	}

	@Override
	public List<UsersVO> getUsersList(UsersVO vo) {
		return usersDAO.getUsersList(vo);
	}

}
