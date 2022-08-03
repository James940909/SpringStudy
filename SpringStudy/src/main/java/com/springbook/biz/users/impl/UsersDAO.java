package com.springbook.biz.users.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.UsersVO;

class UsersRowMapper implements RowMapper<UsersVO>{
	public UsersVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsersVO users = new UsersVO();
		users.setUsersNum(rs.getInt("usersNum"));
		users.setUsersId(rs.getString("usersId"));
		users.setUsersPw(rs.getString("usersPw"));
		users.setUsersName(rs.getString("usersName"));
		users.setUsersEmail(rs.getString("usersEmail"));
		users.setUsersPhone(rs.getString("usersPhone"));
		users.setUsersAddress(rs.getString("usersAddress"));
		return users;
	}
}

@Repository
public class UsersDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	// MySQL ¸í·É¾î
	private final String Users_Insert = "INSERT INTO USERS(usersId, usersPw, usersName, usersEmail, usersPhone, usersAddress) VALUES(?,?,?,?,?,?)";
	private final String Users_Update = "UPDATE USERS SET usersId=?, usersPw=?, usersName=?, usersEmail=?, usersPhone=?, usersAddress=? WHERE usersNum=?";
	private final String Users_Delete = "DELETE USERS WHERE usersNum=?";
	private final String Users_Get = "SELECT * FROM USERS WHERE usersId=? and usersPw=?";
	private final String Users_List = "SELECT * FROM USERS ORDER BY usersNum DESC";
	
	
	
	public void insertUsers(UsersVO vo) {
		Object[] args = { vo.getUsersId(), vo.getUsersPw(), vo.getUsersName(), vo.getUsersEmail(), vo.getUsersPhone(), vo.getUsersAddress() };
		jdbcTemplate.update(Users_Insert, args);
	}
	public void updateUsers(UsersVO vo) {
		Object[] args = { vo.getUsersId(), vo.getUsersPw(), vo.getUsersName(), vo.getUsersEmail(), vo.getUsersPhone(), vo.getUsersAddress(), vo.getUsersNum() };
		jdbcTemplate.update(Users_Update, args);
	}
	public void deleteUsers(UsersVO vo) {
		Object[] args = { vo.getUsersNum() };
		jdbcTemplate.update(Users_Delete, args);
	}
	public UsersVO getUsers(UsersVO vo) {
		Object[] args = { vo.getUsersId(), vo.getUsersPw() };
		System.out.println("jdbcTemplate1: "+jdbcTemplate);
		return jdbcTemplate.queryForObject(Users_Get, args, new UsersRowMapper());
	}
	public List<UsersVO> getUsersList(UsersVO vo) {
		return jdbcTemplate.query(Users_List, new UsersRowMapper());
	}
}
