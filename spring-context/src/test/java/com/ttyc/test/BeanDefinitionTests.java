package com.ttyc.test;

import com.ttyc.test.bean.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.context.annotation6.ConfigForScanning;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanDefinitionTests {

	/**
	 * 可以在基础架构的项目里用，做if判断
	 */
	@Test
	public void testAnnotationBeanDefinition() {
		AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(TestConfig.class);
		AnnotationMetadata metadata = beanDefinition.getMetadata();
		Set<String> annotationTypes = metadata.getAnnotationTypes();
		assertThat(annotationTypes).contains("org.springframework.context.annotation.Scope");
		assertThat(metadata.hasAnnotation("org.springframework.stereotype.Component")).isTrue();

		Set<MethodMetadata> annotatedMethods = metadata.getAnnotatedMethods("org.springframework.scheduling.annotation.Scheduled");
		assertThat(annotatedMethods).hasSize(1);
	}

}