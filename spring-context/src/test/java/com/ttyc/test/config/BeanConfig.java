package com.ttyc.test.config;

import com.ttyc.test.bean.TestConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public TestConfig testConfig() {
		return new TestConfig();
	}
}
