package com.ttyc.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation6.ConfigForScanning;

public class ConfigurationClassReaderTests {

	private final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

	@BeforeEach
	public void setup() {
		QualifierAnnotationAutowireCandidateResolver acr = new QualifierAnnotationAutowireCandidateResolver();
		acr.setBeanFactory(this.beanFactory);
		this.beanFactory.setAutowireCandidateResolver(acr);
	}

	@Test
	public void scanAndRead() {
		beanFactory.registerBeanDefinition("configClass", new RootBeanDefinition(ConfigForScanning.class));
	}
}
