package com.springbook.biz;

public class UsersVO {
	private int usersNum;
	private String usersId;
	private String usersPw;
	private String usersName;
	private String usersEmail;
	private String usersPhone;
	private String usersAddress;
	
	public int getUsersNum() {
		return usersNum;
	}
	public void setUsersNum(int usersNum) {
		this.usersNum = usersNum;
	}
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUsersPw() {
		return usersPw;
	}
	public void setUsersPw(String usersPw) {
		this.usersPw = usersPw;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
	public String getUsersPhone() {
		return usersPhone;
	}
	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}
	public String getUsersAddress() {
		return usersAddress;
	}
	public void setUsersAddress(String usersAddress) {
		this.usersAddress = usersAddress;
	}
	@Override
	public String toString() {
		return "UsersVO [usersNum=" + usersNum + ", usersId=" + usersId + ", usersPw=" + usersPw + ", usersName="
				+ usersName + ", usersEmail=" + usersEmail + ", usersPhone=" + usersPhone + ", usersAddress="
				+ usersAddress + "]";
	}
	
}
