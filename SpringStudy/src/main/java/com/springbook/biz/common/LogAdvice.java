package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	public void printLog(JoinPoint jp) {
		System.out.println("비즈니스 로직 수행 전 로그!");
		String method = jp.getSignature().getName();
		// getSignature.getName() = 메소드 이름을 출력할 수 있다.
		Object[] args = jp.getArgs();
		// getArgs() = 인자목록을 Object배열로 출력할 수 있다.
		System.out.println("[사전처리] " + method + "() 메소드 ARGS 정보: " + args[0].toString());
		
		//around를 활용해 메소드 수행시간 구현해보자.
	}
}
