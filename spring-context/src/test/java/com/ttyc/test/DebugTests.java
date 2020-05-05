package com.ttyc.test;

import org.junit.Test;
import org.springframework.beans.testfixture.beans.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation6.ConfigForScanning;

public class DebugTests {

	@Test
	public void testGetBean() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigForScanning.class);
		TestBean bean = context.getBean(TestBean.class);
	}
}
