package com.ttyc.test.config;

import com.ttyc.test.bean.TestVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public TestVO testConfig() {
		TestVO testVO = new TestVO();
		testVO.setFoo(1);
		return testVO;
	}
}
