package com.ttyc.test;

import com.ttyc.test.bean.TestConfig;
import com.ttyc.test.config.BeanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.testfixture.beans.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation6.ComponentForScanning;

import java.util.Map;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.springframework.util.StringUtils.uncapitalize;

public class BeanContextTest {

	@Test
	void testAnnotationConfigApplicationContext() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.context.annotation6", "com.ttyc.test.config");
		context.refresh();

		ComponentForScanning bean = context.getBean(ComponentForScanning.class);
		assertThat(bean).isNotNull();

		Map<String, Object> configuredBeans = context.getBeansWithAnnotation(Configuration.class);
		assertThat(configuredBeans).hasSize(2);
		assertThat(configuredBeans).containsKeys(uncapitalize(BeanConfig.class.getSimpleName()));

		TestBean testBean = (TestBean) context.getBean(uncapitalize(TestBean.class.getSimpleName()));
		assertThat(testBean).isNotNull();

		Class<?> targetType = StringBuilder.class;
		assertThatExceptionOfType(NoSuchBeanDefinitionException.class)
				.isThrownBy(() -> context.getBean(targetType))
				.withMessageContaining("No qualifying bean");

		assertThat(SingletonBeanRegistry.class.isAssignableFrom(AnnotationConfigApplicationContext.class)).isFalse();
		assertThat(BeanFactory.class.isAssignableFrom(AnnotationConfigApplicationContext.class)).isTrue();
	}

	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		TestConfig bean = context.getBean(TestConfig.class);
		// AnnotatedBeanDefinitionReader-->AnnotatedGenericBeanDefinition
	}
}
