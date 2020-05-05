package com.ttyc.test;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ProcessorInitializer implements ApplicationContextInitializer {
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		applicationContext.addBeanFactoryPostProcessor(new MyProcessor());
	}
}
