package com.ttyc.test.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Scope
public class TestAnnotatedClass {

	@Scheduled
	public String test() {
		return "";
	}
}
