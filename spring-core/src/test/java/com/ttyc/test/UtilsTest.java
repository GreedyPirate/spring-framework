package com.ttyc.test;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;


public class UtilsTest {

	@Test
	public void testReflectionUtils() {
		// 从父类里获取字段
		Field field = ReflectionUtils.findField(Sub.class, "age");
		assertThat(field).isNotNull();

		// 反射调用方法
		Sub sub = new Sub();
		Method method = ReflectionUtils.findMethod(Sub.class, "setAge", int.class);
		assertThat(method).isNotNull();

		ReflectionUtils.makeAccessible(method);
		ReflectionUtils.invokeMethod(method, sub, 20);
		assertThat(sub.getAge()).isEqualTo(20);

		// 获取所有的declared方法，并执行回调
		ReflectionUtils.doWithLocalMethods(Sub.class, (m)->{
			System.out.println("method = " + m.getName());
		});

	}

	@Test
	public void testPlaceHolder() throws IOException {
		String location = SystemPropertyUtils.resolvePlaceholders("${os.name}/logs/app.log");
		assertThat(location).isEqualTo("Mac OS X/logs/app.log");

		ClassPathResource resource = new ClassPathResource("org/springframework/core/io/example.xml");
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);
		assertThat(properties.get("foo")).isEqualTo("bar");
	}


}

class Parent {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Sub extends Parent {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
