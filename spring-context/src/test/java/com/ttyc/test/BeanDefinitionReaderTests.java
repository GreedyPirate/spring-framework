package com.ttyc.test;

import com.ttyc.test.config.BeanConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

public class BeanDefinitionReaderTests {

	private final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

	@Test
	public void testReaderConfig() {
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
		reader.register(BeanConfig.class);
	}
}
