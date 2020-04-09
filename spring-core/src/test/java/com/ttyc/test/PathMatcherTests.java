package com.ttyc.test;

import org.junit.jupiter.api.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PathMatcherTests {
	private final AntPathMatcher pathMatcher = new AntPathMatcher();

	@Test
	public void testInclude() {
		assertThat(pathMatcher.match("/a/*", "/a/b")).isFalse();
		assertThat(pathMatcher.match("/a/b/c/*", "/a/b")).isFalse();

	}
}
