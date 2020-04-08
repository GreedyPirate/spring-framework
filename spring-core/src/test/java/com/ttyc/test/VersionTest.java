package com.ttyc.test;

import org.junit.jupiter.api.Test;
import org.springframework.core.SpringVersion;

public class VersionTest {

	@Test
	public void testVersion() {
		String version = SpringVersion.getVersion();
		System.out.println("version = " + version);
	}
}
