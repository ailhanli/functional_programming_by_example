package com.ailhanli.practice2;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//log4j support lambda. now out 3 seconds taken getMessage wont execute if the logger level is WARN
public class HelloLoggingLazy {

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

	
	//task: use lazy execution
	
	public void doSaomethingLazy() {
		System.out.println("function is started "+LocalDateTime.now());
		
		logger.debug(()->getMessage());
		
		System.out.println("function is finished "+LocalDateTime.now());
	}
	
	public static void main(String[] args) {
		HelloLoggingLazy hl = new HelloLoggingLazy();
		hl.doSomething();
	}
	
}

