package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	public void printLog(JoinPoint jp) {
		System.out.println("����Ͻ� ���� ���� �� �α�!");
		String method = jp.getSignature().getName();
		// getSignature.getName() = �޼ҵ� �̸��� ����� �� �ִ�.
		Object[] args = jp.getArgs();
		// getArgs() = ���ڸ���� Object�迭�� ����� �� �ִ�.
		System.out.println("[����ó��] " + method + "() �޼ҵ� ARGS ����: " + args[0].toString());
		
		//around�� Ȱ���� �޼ҵ� ����ð� �����غ���.
	}
}
