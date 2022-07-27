package com.springbook.biz;

import java.util.List;

public interface UsersService {
	//회원가입
	void insertUsers(UsersVO vo);
	//회원정보수정
	void updateUsers(UsersVO vo);
	//회원탈퇴
	void deleteUsers(UsersVO vo);
	//회원상세보기
	UsersVO getUsers(UsersVO vo);
	//회원목록조회
	List<UsersVO> getUsersList(UsersVO vo);
}
