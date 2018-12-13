package com.ailhanli.practice2;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloLogging {

	private Logger logger = LogManager.getLogger(getClass());

	public void doSomething() {
		System.out.println("function is started "+LocalDateTime.now());
		
		logger.debug(getMessage());
		
		System.out.println("function is finished "+LocalDateTime.now());
	}

	private String getMessage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello world!";
	}

	public static void main(String[] args) {
		HelloLogging hl = new HelloLogging();
		hl.doSomething();
	}
	
	//task: use lazy execution
	
//	public void doSaomethingLazy() {
//		System.out.println("function is started "+LocalDateTime.now());
//		
//		logger.debug(()->getMessage());
//		
//		System.out.println("function is finished "+LocalDateTime.now());
//	}
//	
//	public static void main(String[] args) {
//		HelloLogging hl = new HelloLogging();
//		hl.doSaomethingLazy();
//	}
}