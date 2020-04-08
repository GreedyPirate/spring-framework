package com.ttyc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.beans.testfixture.beans.TestBean;

public class ManualRegistrySingletonBeanTest {

	@Test
	public void testManualRegistry() {
		DefaultSingletonBeanRegistry registry = new DefaultSingletonBeanRegistry();
		
		TestBean tb = new TestBean();
		registry.registerSingleton("tb", tb);
	}
}
