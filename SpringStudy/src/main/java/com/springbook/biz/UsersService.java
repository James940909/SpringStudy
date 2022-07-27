package com.springbook.biz;

import java.util.List;

public interface UsersService {
	//ȸ������
	void insertUsers(UsersVO vo);
	//ȸ����������
	void updateUsers(UsersVO vo);
	//ȸ��Ż��
	void deleteUsers(UsersVO vo);
	//ȸ���󼼺���
	UsersVO getUsers(UsersVO vo);
	//ȸ�������ȸ
	List<UsersVO> getUsersList(UsersVO vo);
}
