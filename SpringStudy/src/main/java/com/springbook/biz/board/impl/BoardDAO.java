package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.BoardVO;

class BoardRowMapper implements RowMapper<BoardVO>{
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setCnt(rs.getInt("cnt"));
		return board;
	}
}

@Repository("boardDAO")
public class BoardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// MySQL ��ɾ�
	private final String Board_Insert = "INSERT INTO BOARD(title, writer, content) VALUES(?,?,?)"; 
	private final String Board_Update = "UPDATE BOARD SET title=?, content=? WHERE seq=?";
	private final String Board_Delete = "DELETE BOARD WHERE seq=?";
	private final String Board_Get = "SELECT * FROM BOARD WHERE seq=?";
	private final String Board_List = "SELECT * FROM BOARD ORDER BY seq DESC";
	// CRUD �޼ҵ� ����
	// �۵��
	public void insertBoard(BoardVO vo) {
		Object[] args = { vo.getTitle(), vo.getWriter(), vo.getContent() };
		jdbcTemplate.update(Board_Insert, args);
	}
	// �ۼ���
	public void updateBoard(BoardVO vo) {
		Object[] args = { vo.getTitle(), vo.getContent(), vo.getSeq() };
		jdbcTemplate.update(Board_Update, args);
	}
	// �ۻ���
	public void deleteBoard(BoardVO vo) {
		Object[] args = { vo.getSeq() };
		jdbcTemplate.update(Board_Delete, args);
	}
	// �� �󼼺���
	public BoardVO getBoard(BoardVO vo) {
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(Board_Get, args, new BoardRowMapper());
	}
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo){
		return jdbcTemplate.query(Board_List, new BoardRowMapper());
	}
}
